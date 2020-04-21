package com.dong.mymall.service.impl;

import com.dong.mymall.mapper.UserMapper;
import com.dong.mymall.pojo.UserDO;
import com.dong.mymall.service.UserService;
import com.dong.mymall.service.ex.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 处理用户数据的业务层实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${password.length-max}")
    private int passwordLengthMax;
    @Value("${password.length-min}")
    private int passwordLengthMin;
    @Value("${username.length-max}")
    private int usernameLengthMax;
    @Value("${username.length-min}")
    private int usernameLengthMin;

    public Long addnew(UserDO userDO)
            throws ArgumentEmptyException, DataLengthNotMatchException, DataFormatNotMatchException,
            UsernameDuplicateException, EmailDuplicateException, InsertException {
        // 判断userDO是否为null
        if (userDO == null) {
            // 是：ArgumentEmptyException
            throw new ArgumentEmptyException("注册失败，输入的参数不能为空！");
        }
        // 判断输入的用户名是否为空
        if (StringUtils.isEmpty(userDO.getUsername())) {
            // 是：ArgumentEmptyException
            throw new ArgumentEmptyException("注册失败，请输入用户名！");
        }
        // 获取用户名长度
        int userLength = userDO.getUsername().length();
        // 判断用户名长度是否在指定范围内
        if (userLength < usernameLengthMin || userLength > usernameLengthMax) {
            // 否：DataLengthNotMatchException
            throw new DataLengthNotMatchException("注册失败，密码长度需要在" + usernameLengthMin + "~" + usernameLengthMax + "之间！");
        }
        // 判断输入的密码是否为空
        if (StringUtils.isEmpty(userDO.getPassword())) {
            // 是：ArgumentEmptyException
            throw new ArgumentEmptyException("注册失败，请输入密码！");
        }
        // 获取密码长度
        int pwdLength = userDO.getPassword().length();
        // 判断密码长度是否在指定范围内
        if (pwdLength < passwordLengthMin || pwdLength > passwordLengthMax) {
            // 否：DataLengthNotMatchException
            throw new DataLengthNotMatchException("注册失败，密码长度需要在" + passwordLengthMin + "~" + passwordLengthMax + "之间！");
        }
        // 判断邮箱是否为空
        if (StringUtils.isEmpty(userDO.getEmail())) {
            // 是：ArgumentEmptyException
            throw new ArgumentEmptyException("注册失败，请输入邮箱！");
        }
        // 定义验证邮箱的正则表达式
        String emailEegex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        // 判断邮箱格式是否不正确
        if (!userDO.getEmail().matches(emailEegex)) {
            // 是：DataFormatNotMatchException
            throw new DataFormatNotMatchException("注册失败，请输入正确的邮箱格式！");
        }
        // 调用持久层方法，通过用户名查找用户
        UserDO result = findByUsername(userDO.getUsername());
        // 判断查到的数据是否不为null
        if (result != null) {
            // 是：
            throw new UsernameDuplicateException("注册失败，该用户名已存在！");
        }
        // 调用持久层方法，通过邮箱查找用户
        result = findByEmail(userDO.getEmail());
        // 判断查到的结果是否不为null
        if (result != null) {
            // 是：EmailDuplicateException
            throw new EmailDuplicateException("注册失败，该邮箱已被使用！");
        }
        // 生成盐值
        String salt = UUID.randomUUID().toString();
        // 调用加密方法加密
        String password = getMD5Password(userDO.getPassword(), salt);
        // 向userDO中更新password属性，添加salt、isDelete和四个日志信息，昵称默认为用户名
        userDO.setNickname(userDO.getUsername());
        userDO.setPassword(password);
        userDO.setSalt(salt);
        userDO.setIsDelete(0);
        Date now = new Date();
        String username = userDO.getUsername();
        userDO.setCreateUser(username);
        userDO.setCreateTime(now);
        userDO.setModifiedUser(username);
        userDO.setModifiedTime(now);
        // 调用持久层方法，插入用户信息
        insert(userDO);
        // 判断userDO是否为null
        if (userDO.getId() == null) {
            // 是：InsertException
            throw new InsertException("数据插入失败，插入数据时出现未知错误！");
        }
        return userDO.getId();
    }

    @Override
    public void modifyInfo(UserDO userDO) throws UserNotFoundException {
        // 判断userDO是否为null
        if (userDO == null) {
            // 是：return
            return;
        }
        // 调用持久层方法，根据id查找用户数据
        UserDO result = findById(userDO.getId());
        // 判断返回结果是否为null
        if (result == null) {
            // 是：UserNotFoundException
            throw new UserNotFoundException("修改用户个人信息失败，找不到对应的用户！");
        }
        // 判断userDO.nickname是否为空
        if (StringUtils.isEmpty(userDO.getNickname())) {
            // 是：将nickname设为username的值
            userDO.setNickname(result.getUsername());
        }
        // 补充日志属性
        userDO.setModifiedUser(result.getUsername());
        userDO.setModifiedTime(new Date());
        // 调用持久层方法，修改用户个人信息
        updateInfoById(userDO);
    }

    @Override
    public void modifyAvatar(UserDO userDO) throws UserNotFoundException, ArgumentEmptyException, UpdateException {
        // 判断userDO是否为null
        if (userDO == null) {
            // 是：return
            return;
        }
        // 调用持久层方法，根据id查找用户数据
        UserDO result = findById(userDO.getId());
        // 判断返回结果是否为null
        if (result == null) {
            // 是：UserNotFoundException
            throw new UserNotFoundException("修改用户头像失败，找不到对应的用户！");
        }
        // 判断userDO.avatar是否为空
        if (StringUtils.isEmpty(userDO.getAvatar())) {
            // 是：ArgumentEmptyException
            throw new ArgumentEmptyException("修改用户头像失败，请选择上传的头像！");
        }
        // 补全日志数据
        userDO.setModifiedUser(result.getUsername());
        userDO.setModifiedTime(new Date());
        // 调用持久层方法，修改用户头像
        updateAvatarById(userDO);
    }

    @Override
    public UserDO login(String username, String password) throws UserNotFoundException, PasswordNotMatchException{
        // 调用持久层方法，根据用户名查找用户
        UserDO result = findByUsername(username);
        // 判断返回结果是否为null
        if (result == null) {
            // 是：UserNotFoundException
            throw new UserNotFoundException("用户名或密码错误！");
        }
        // 判断result.isDelete是否为1
        if (result.getIsDelete() == 1) {
            // 是：UserNotFoundException
            throw new UserNotFoundException("用户名或密码错误！");
        }
        // 加密输入的密码
        String md5Password = getMD5Password(password, result.getSalt());
        // 判断加密后的密码于改用户的密码是否不一致
        if(!md5Password.equals(result.getPassword())){
            // 是：UserNotFoundException
            throw new PasswordNotMatchException("用户名或密码错误！");
        }
        // 创建UserDO对象封装需要返回的数据
        UserDO userDO = new UserDO();
        userDO.setId(result.getId());
        userDO.setNickname(result.getNickname());
        userDO.setAvatar(result.getAvatar());
        // 返回数据
        return userDO;
    }


    /**
     * 使用md5信息摘要算法加密
     *
     * @param password 未加密的密码
     * @param salt     盐值
     * @return 加密后的密码
     */
    private String getMD5Password(String password, String salt) {
        String result = salt + password + salt;
        for (int i = 0; i < 3; i++) {
            result = DigestUtils.md5Hex(result);
        }
        return result;
    }

    /**
     * 插入用户数据
     *
     * @param userDO 用户数据
     */
    private void insert(UserDO userDO) {
        Integer rows = userMapper.insert(userDO);
        if (rows != 1) {
            throw new InsertException("数据插入失败，插入数据时出现未知错误！");
        }
    }

    /**
     * 根据id修改用户的头像
     *
     * @param userDO 修改后的用户数据
     */
    private void updateAvatarById(UserDO userDO) {
        Integer rows = userMapper.updateAvatarById(userDO);
        if (rows != 1) {
            throw new UpdateException("数据更新失败，更新数据时出现未知错误！");
        }
    }

    /**
     * 根据id修改用户个人信息
     *
     * @param userDO 修改后的用户数据
     * @return 修改成功的行数
     */
    private void updateInfoById(UserDO userDO) {
        Integer rows = userMapper.updateInfoById(userDO);
        if (rows != 1) {
            throw new UpdateException("数据更新失败，更新数据时出现未知错误！");
        }
    }

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 查到的用户数据
     */
    private UserDO findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 根据邮箱查找用户
     *
     * @param email 邮箱
     * @return 查到的用户数据
     */
    private UserDO findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    /**
     * 根据id查找用户
     *
     * @param id 用户id
     * @return 查找的用户数据
     */
    private UserDO findById(Long id) {
        return userMapper.findById(id);
    }

}
