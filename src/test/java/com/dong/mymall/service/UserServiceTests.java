package com.dong.mymall.service;

import com.dong.mymall.pojo.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService service;

    @Test
    public void addnew(){
        UserDO userDO = new UserDO();
        userDO.setUsername("admin1");
        userDO.setPassword("123456");
        userDO.setEmail("admin1@163.com");
        service.addnew(userDO);
    }
    @Test
    public void modifyInfo(){
        UserDO userDO = new UserDO();
        userDO.setId(5L);
        userDO.setNickname("a65625460");
        userDO.setGender(0);
        userDO.setAge(20);
        userDO.setPhone("13800138000");
        userDO.setModifiedTime(new Date());
        userDO.setModifiedUser("a65625460");
        service.modifyInfo(userDO);
    }

    @Test
    public void modifyAvatar(){
        UserDO userDO = new UserDO();
        userDO.setId(12L);
        userDO.setAvatar("/img/avatar/1587456487157375336736997200.JPG");
        userDO.setModifiedTime(new Date());
        userDO.setModifiedUser("a656254601");
        service.modifyAvatar(userDO);
    }

    @Test
    public void login(){
        String username = "a65625460";
        String password = "a65092679";
        UserDO userDO = service.login(username, password);
        System.err.println(userDO);
    }
}
