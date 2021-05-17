package com.imooc.jdbc.newsmgmt.command;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imooc.jdbc.common.DbUtils;
import com.imooc.jdbc.newsmgmt.NewsMgmt;
import com.imooc.jdbc.newsmgmt.entity.News;
import com.imooc.jdbc.sample.DbUtilsSample;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * 添加新闻
 */
public class InsertCommand implements Command{
    @Override
    public void execute() {
        // 接收控制台输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新闻标题");
        String title = sc.next();
        System.out.println("请输入新闻内容");
        String content = sc.next();
        System.out.println("请输入新闻日期，按年-月-日的形式输入");
        String strDate = sc.next();
        // Date类型转换
        java.util.Date udDate = null;
        java.sql.Date sqDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            udDate = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = udDate.getTime();
        sqDate = new java.sql.Date(time);

        // 加载properties文件
        Properties properties = new Properties();
        String propertyFile = NewsMgmt.class.getResource("/druid-config.properties").getPath();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // propertyFile编译
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileInputStream(propertyFile));
            // datasource
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // connection
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            // sql
            String sql = "insert into news(title,content,create_time) values(?,?,?)";
            // set value
            QueryRunner qr = new QueryRunner(ds);
            List<News> list = qr.insert(sql,new BeanListHandler<>(News.class),new Object[]{title,content,sqDate});
            conn.commit();
            if(list!=null){
                System.out.println("添加成功");
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
            //自动关闭连接
        }

    }
}
