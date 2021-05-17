package com.imooc.jdbc.hrapp.command;

import java.sql.*;
import java.util.Scanner;

public class QueryCommand implements Command{
    @Override
    public void execute() {
        System.out.println("请输入部门名称：");
        Scanner in = new Scanner(System.in);
        String pname = in.next();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                    "root", "19950718");
            //创建Statement对象
            stmt = conn.createStatement();
            // 结果集
            rs = stmt.executeQuery("select * from employee where dname='"+pname+"'");

            //遍历查询结果
            while(rs.next()){
                Integer eno = rs.getInt(1);  // JDBC中字段索引从1开始，非0
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                System.out.println(dname+"-"+eno+"-"+ename+"-"+salary);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭连接，释放资源
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn!=null && conn.isClosed()==false){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
