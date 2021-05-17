package com.imooc.jdbc.goods.command;

import java.sql.*;

public class QueryCommand implements Command{
    @Override
    public void excute() {
        System.out.println("正在添加信息到商品表...");
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
            // 结果为是否添加成功
            rs = stmt.executeQuery("select * from goods where price<3500 ");
            // 判断是否成功添加信息
            if(rs!=null){
                System.out.println("价格在3500以下的商品信息查询成功！");
            }else{
                System.out.println("价格在3500以下的商品信息查询失败！");
            }
            // 输出添加结果
            while (rs.next()){
                Integer gnum = rs.getInt(1);
                String gname = rs.getString("name");
                Float gprice = rs.getFloat("price");
                String gdesp = rs.getString("desp");
                System.out.println(gnum + " "+gname+" "+gprice+"  "+gdesp);
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
