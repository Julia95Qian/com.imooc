package com.imooc.spring.ioc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//�������ע��Ĭ��beanIdΪ��������ĸСд
@Repository
public class UserDao implements IUserDao{
    public UserDao(){
        System.out.println("���ڴ���UserDao:" + this);
    }
}
