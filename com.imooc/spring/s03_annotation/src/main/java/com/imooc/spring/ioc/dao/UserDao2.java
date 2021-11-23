package com.imooc.spring.ioc.dao;

import org.springframework.stereotype.Repository;

//组件类型注解默认beanId为类名首字母小写
@Repository
public class UserDao2 implements IUserDao{
    public UserDao2(){
        System.out.println("正在创建UserDao2:" + this);
    }
}
