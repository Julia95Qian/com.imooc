package com.imooc.jdbc.newsmgmt.command;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imooc.jdbc.newsmgmt.NewsMgmt;
import com.imooc.jdbc.newsmgmt.entity.News;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class QueryCommand implements Command {
    @Override
    public void execute() {
        Properties properties = new Properties();
        String propertyFile = NewsMgmt.class.getResource("/druid-config.properties").getPath();
        try {
            propertyFile = new URLDecoder().decode(propertyFile, "UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // 查询执行到某个数据库
            QueryRunner qr = new QueryRunner(ds);
            // 查询sql语句，返回值自动以News的方式包装，sql语句中第一个参数设置为10
            String sql = "select * from news";
            List<News> list = qr.query(sql, new BeanListHandler<>(News.class));
            // 显示新闻列表
            for (News news : list) {
                System.out.println(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 连接自动关闭

        }
    }
}
