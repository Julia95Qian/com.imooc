package com.imooc.jdbc.newsmgmt.command;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imooc.jdbc.newsmgmt.NewsMgmt;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DeleteCommand implements Command{
    @Override
    public void execute() {
        // 接收控制台输入
        System.out.println("请输入要删除的新闻id");
        Scanner sc = new Scanner(System.in);
        int id = 0;
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("输入格式有误，请重新输入");
            return;
        }

        Properties properties = new Properties();
        String propertyFile = NewsMgmt.class.getResource("/druid-config.properties").getPath();
        Connection conn = null;

        try {
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            // sql
            String sql = "delete from news where id=?";
            QueryRunner qr = new QueryRunner(ds);
            int cnt = qr.update(sql,new Object[]{id});
            conn.commit();
            //当删除不存在的id时，提示删除失败
            if(cnt>0){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if(conn!=null && !conn.isClosed()){
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                if(conn!=null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
