package com.imooc.spring.aop.service;

import com.imooc.spring.aop.dao.EmployeeDao;

public class EmployeeService {
    private EmployeeDao employeeDao;
    public void entry(){
        System.out.println("ִ��Ա����ְҵ���߼�");
        employeeDao.insert();
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
