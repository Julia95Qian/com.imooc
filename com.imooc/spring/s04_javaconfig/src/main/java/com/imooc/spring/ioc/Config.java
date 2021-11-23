package com.imooc.spring.ioc;

import com.imooc.spring.ioc.controller.UserController;
import com.imooc.spring.ioc.dao.UserDao;
import com.imooc.spring.ioc.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration //当前类为配置类，用于替代applicationContext.xml
@ComponentScan(basePackages = "com.imooc")
public class Config {
    @Bean //方法返回对象放入容器，beanId为方法名
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        System.out.println("已创建UserDao" + userDao);
        return userDao;
    }
    @Bean
    public UserService userService(UserDao userDao){
        UserService userService = new UserService();
        System.out.println("已创建UserService" + userService);
        userService.setUserDao(userDao);
        System.out.println("setUserDap" + userDao);
        return userService;
    }
    @Bean
    public UserController userController(UserService userService){
        UserController userController = new UserController();
        System.out.println("已创建UserController" + userController);
        userController.setUserService(userService);
        System.out.println("setUserService" + userService);
        return userController;
    }

}
