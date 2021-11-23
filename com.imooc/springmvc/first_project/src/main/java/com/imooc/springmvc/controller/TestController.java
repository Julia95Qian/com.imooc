package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/t")   //localhost/t
    @ResponseBody   //
    public String test() {
        return "SUCCESS";
    }

    @PostMapping("/login")
    @ResponseBody
    public String postMapping(User user){
        return  "<fieldset><legend>success</legend>admin: " +user.getUsername()+
                "<br>password: "+user.getPassword()+"</fieldset>";
    }
}
