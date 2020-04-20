package com.dong.mymall.controller;

import com.dong.mymall.pojo.JsonResult;
import com.dong.mymall.pojo.UserDO;
import com.dong.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public JsonResult<Long> addnew(UserDO userDO){
        Long data = userService.addnew(userDO);
        return JsonResult.getSuccessResult(data);
    }

    @PostMapping("/modifyInfo")
    public JsonResult<Void> modifyInfo(UserDO userDO){
        userService.modifyInfo(userDO);
        return JsonResult.getSuccessResult();
    }
}
