package com.dong.mymall.service;

import com.dong.mymall.pojo.UserDO;
import com.dong.mymall.service.ex.*;

/**
 * 处理用户数据的业务层接口
 */
public interface UserService {
    /**
     * 添加新用户
     *
     * @param userDO 用户数据
     * @return 用户id
     */
    Long addnew(UserDO userDO)
            throws ArgumentEmptyException, DataLengthNotMatchException, DataFormatNotMatchException,
            UsernameDuplicateException, EmailDuplicateException, InsertException;


    /**
     * 修改用户个人信息
     * @param userDO 修改后的用户信息
     */
    void modifyInfo(UserDO userDO) throws UserNotFoundException;

    /**
     * 修改用户头像
     * @param userDO 修改后的用户数据
     */
    void modifyAvatar(UserDO userDO) throws UserNotFoundException,ArgumentEmptyException,UpdateException;

    UserDO login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;
}
