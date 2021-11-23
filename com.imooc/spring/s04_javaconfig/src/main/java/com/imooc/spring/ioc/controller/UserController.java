package com.imooc.spring.ioc.controller;

import com.imooc.spring.ioc.service.UserService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
