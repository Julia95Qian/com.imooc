package com.imooc.jdbc.hrapp.command;

import com.imooc.jdbc.common.DbUtils;
import com.imooc.jdbc.hrapp.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaginationCommand implements Command{
    @Override
    public void execute(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入页号：");
        int page = in.nextInt();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //
        List<Employee> list = new ArrayList<Employee>();
        try {
            conn = DbUtils.getConnection();
            String sql = "select * from employee limit ?,10"; //从某行开始10行
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,(page-1)*10);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Integer eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                Date hiredate = rs.getDate("hiredate"); // sql里的Date继承自util里的Date

                Employee emp = new Employee();
                emp.setEno(eno);
                emp.setEname(ename);
                emp.setSalary(salary);
                emp.setDname(dname);
                emp.setHiredate(hiredate);
                list.add(emp);
            }
            System.out.println(list.size());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(rs,pstmt,conn);
        }
    }
}
