package com.imooc.spring.ioc.services;

import com.imooc.spring.ioc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope("prototype")//同XML中bean scope
public class UserService {
    @Value("${metaData}")
    private String metaData;
    public UserService() {
        System.out.println("正在创建UserService:" + this);
    }

    @PostConstruct//同XML中bean init-method
    public void init(){
        System.out.println("初始化UserService对象, metaData=" + metaData);
    }

    private IUserDao userDao;
    public IUserDao getUdao(){
        return userDao;
    }
    @Autowired
    public void setUserDao(IUserDao userDao){
        System.out.println("setUserDao:" + userDao);
        this.userDao = userDao;
    }
}
