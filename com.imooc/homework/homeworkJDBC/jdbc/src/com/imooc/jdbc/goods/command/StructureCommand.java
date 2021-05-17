package com.imooc.jdbc.goods.command;

import java.sql.*;

public class StructureCommand implements Command{
    @Override
    public void excute() {
        System.out.println("正在创建商品信息表...");
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
            // 结果为是否创建成功
            // 返回数据行数或者0=未创建结构
            rs = stmt.executeUpdate("create table goods(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品编号'," +
                    "name VARCHAR(20) NOT NULL COMMENT '商品名称'," +
                    "price FLOAT NOT NULL COMMENT '商品价格'," +
                    "desp VARCHAR(30) NOT NULL COMMENT '商品描述'" +
                    ")");

            // 判断是否成功建表
            if(rs!=-1){
                System.out.println("商品信息表goods建立成功！");
            }else{
                System.out.println("商品信息表goods建立失败！");
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
