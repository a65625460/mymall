package com.dong.mymall.mapper;

import com.dong.mymall.pojo.UserDO;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {

    /**
     * 插入用户数据
     * @param userDO 用户数据
     * @return 插入成功的数据条数
     */
    Integer insert(UserDO userDO);

    /**
     * 根据id修改用户个人信息
     * @param userDO 修改后的用户数据
     * @return 修改成功的行数
     */
    Integer updateInfoById(UserDO userDO);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 查到的用户数据
     */
    UserDO findByUsername(String username);

    /**
     * 根据邮箱查找用户
     * @param email 邮箱
     * @return 查到的用户数据
     */
    UserDO findByEmail(String email);

    /**
     * 根据id查找用户
     * @param id 用户id
     * @return 查找的用户数据
     */
    UserDO findById(Long id);
}
