package com.imooc.spring.ioc.services;

import com.imooc.spring.ioc.dao.IUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentService {
    @Resource(name="userDao2")
    private IUserDao userDao;
    public void joinDepartment(){
        System.out.println("DepartmentService userDao" + userDao);
    }

}
