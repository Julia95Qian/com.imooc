package com.imooc.spring.ioc.dao;

import org.springframework.stereotype.Repository;

//�������ע��Ĭ��beanIdΪ��������ĸСд
@Repository
public class UserDao2 implements IUserDao{
    public UserDao2(){
        System.out.println("���ڴ���UserDao2:" + this);
    }
}
