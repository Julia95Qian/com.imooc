package com.imooc.spring.aop.service;

import com.imooc.spring.aop.dao.UserDao;

/**
 * �û�����
 */
public class UserService {
    private UserDao userDao;

    public void createUser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ִ��Ա����ְҵ���߼�");
        userDao.insert();
    }

    public String generateRandomPassword(String type , Integer length){
        System.out.println("��" + type + "��ʽ����"+ length  + "λ�������");
        return "Zxcquei1";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
