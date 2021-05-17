package com.imooc.jdbc.newsmgmt.command;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imooc.jdbc.newsmgmt.NewsMgmt;
import com.imooc.jdbc.newsmgmt.entity.News;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class UpdateCommand implements Command{
    @Override
    public void execute() {
        // 接收控制台输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的新闻id");
        int id = 0;
        try{
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("输入格式有误，请重新输入");
            return;
        }
        // 加载properties
        Properties properties = new Properties();
        String propertyFile = NewsMgmt.class.getResource("/druid-config.properties").getPath();
        Connection conn = null;

        try {
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            conn = ds.getConnection();
            conn.setAutoCommit(false);

            // sql1：查询id的新闻信息
            String sql1 = "select * from news where id = ?";
            QueryRunner qr = new QueryRunner(ds);
            List<News> news = qr.query(sql1,new BeanListHandler<>(News.class), new Object[]{id});
            System.out.println(news);

            // 接收控制台输入
            System.out.println("请输入要修改的新闻标题");
            String title = sc.next();
            System.out.println("请输入要修改的新闻内容");
            String content = sc.next();

            // sql2:修改此id的新闻内容
            String sql2 = "update news set title=?, content=? where id=?";
            int cnt = qr.update(sql2,new Object[]{title,content,id});
            conn.commit();
            //当修改不存在的id时，提示修改失败
            if(cnt>0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
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
