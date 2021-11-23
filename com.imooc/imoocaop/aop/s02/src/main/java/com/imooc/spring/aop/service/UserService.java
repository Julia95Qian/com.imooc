package com.imooc.spring.aop.service;

import com.imooc.spring.aop.dao.UserDao;

/**
 * 用户服务
 */
public class UserService {
    private UserDao userDao;

    public void createUser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("execute UserService createUser");
        userDao.insert();
    }

    public String generateRandomPassword(String type , Integer length){
        System.out.println("按" + type + "方式生成"+ length  + "位随机密码");
        return "Zxcquei1";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
