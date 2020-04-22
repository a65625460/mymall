package com.dong.mymall.controller;

import com.dong.mymall.pojo.JsonResult;
import com.dong.mymall.pojo.UserDO;
import com.dong.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public JsonResult<Long> addnew(UserDO userDO) {
        Long data = userService.addnew(userDO);
        return JsonResult.getSuccessResult(data);
    }

    @PostMapping("/info/modify")
    public JsonResult<Void> modifyInfo(UserDO userDO) {
        userService.modifyInfo(userDO);
        return JsonResult.getSuccessResult();
    }

    @PostMapping("/avatar/modify")
    public JsonResult<Void> modifyAvatar(UserDO userDO) {
        userService.modifyAvatar(userDO);
        return JsonResult.getSuccessResult();
    }

    @PostMapping("/login")
    public JsonResult<UserDO> login(String username, String password, HttpSession session) {
        UserDO data = userService.login(username, password);
        session.setAttribute("avatar",data.getAvatar());
        session.setAttribute("id",data.getId());
        session.setAttribute("username",username);
        return JsonResult.getSuccessResult(data);
    }

    @PostMapping("/logout")
    public JsonResult<Void> login(HttpSession session) {
        session.invalidate();
        return JsonResult.getSuccessResult();
    }
}
