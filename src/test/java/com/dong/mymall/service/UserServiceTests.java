package com.dong.mymall.service;

import com.dong.mymall.pojo.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
