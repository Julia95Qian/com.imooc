package com.imooc.jdbc.goods.command;

import java.sql.*;

// 功能二：插入表内容
public class InsertCommand implements Command{
    @Override
    public void excute() {
        System.out.println("正在添加信息到商品表...");
        Connection conn = null;
        Statement stmt = null;
        int rs = 0;
        try {
            //加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                    "root", "19950718");
            //创建Statement对象
            stmt = conn.createStatement();
            // 结果为是否添加成功
            rs = stmt.executeUpdate("insert into goods(name,price,desp)" +
                    "values('手机',2000,'黑色，存储容量')," +
                    " ('冰箱',1500,'银色，对开门')," +
                    "('洗衣机',3000,'滚筒')," +
                    "('空调',4000,'变频空调')");
            // 判断是否成功添加信息
            if(rs!=-1){
                System.out.println("商品信息表goods添加成功！");
            }else{
                System.out.println("商品信息表goods添加失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭连接，释放资源

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
