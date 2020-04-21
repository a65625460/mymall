package com.dong.mymall.mapper;

import com.dong.mymall.pojo.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void insert(){
        UserDO userDO = new UserDO();
        userDO.setUsername("admin");
        userDO.setPassword("123456");
        userDO.setAge(21);
        userDO.setGender(1);
        userDO.setEmail("admin@163.com");
        userDO.setIsDelete(0);
        userDO.setNickname("admin");
        userDO.setSalt("123");
        userDO.setPhone("13800138000");
        userDO.setAvatar("avatar");
        userDO.setCreateTime(new Date());
        userDO.setCreateUser("admin");
        userDO.setModifiedTime(new Date());
        userDO.setModifiedUser("admin");
        Integer rows = mapper.insert(userDO);
        System.err.println("rows=" + rows);
    }

    @Test
    public void updateAvatarById(){
        UserDO userDO = new UserDO();
        userDO.setId(11L);
        userDO.setAvatar("/img/avatar/1587456487157375336736997200.JPG");
        userDO.setModifiedTime(new Date());
        userDO.setModifiedUser("a65625460");
        mapper.updateAvatarById(userDO);
    }

    @Test
    public void updateInfoById(){
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setNickname("admin");
        userDO.setGender(0);
        userDO.setAge(20);
        userDO.setPhone("13800138000");
        userDO.setModifiedTime(new Date());
        userDO.setModifiedUser("admin");
        mapper.updateInfoById(userDO);
    }

    @Test
    public void findByUsername(){
        String username = "admin";
        UserDO userDO = mapper.findByUsername(username);
        System.err.println(userDO);
    }

    @Test
    public void findByEmail(){
        String email = "admin@163.com";
        UserDO userDO = mapper.findByEmail(email);
        System.err.println(userDO);
    }

    @Test
    public void findById(){
        Long id = 1L;
        UserDO userDO = mapper.findById(id);
        System.err.println(userDO);
    }
}
