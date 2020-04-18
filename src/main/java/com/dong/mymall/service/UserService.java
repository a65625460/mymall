package com.dong.mymall.service;

import com.dong.mymall.pojo.UserDO;

/**
 * 处理用户数据的业务层接口
 */
public interface UserService {
    /**
     * 添加新用户
     * @param userDO 用户数据
     */
    void addnew(UserDO userDO);
}
