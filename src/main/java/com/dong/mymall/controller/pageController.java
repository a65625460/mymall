package com.dong.mymall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该控制器用于响应整个页面给用户
 */
@Controller
public class pageController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/page/{page}")
    public String getPage(@PathVariable("page") String page){
        return page;
    }
}
