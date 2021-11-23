package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/t")   //localhost/t
    @ResponseBody   //直接响应字符串，不跳转页面
    public String test() {
        return "SUCCESS";
    }

    @PostMapping("/login")
    @ResponseBody
    public String postMapping(User user){
        return  "<fieldset><legend>登陆成功</legend>用户名：" +user.getUsername()+
                "<br>密码："+user.getPassword()+"</fieldset>";
    }
}
