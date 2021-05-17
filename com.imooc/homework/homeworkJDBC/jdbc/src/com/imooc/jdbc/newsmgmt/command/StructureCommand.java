package com.imooc.jdbc.newsmgmt.command;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imooc.jdbc.common.DbUtils;
import com.imooc.jdbc.newsmgmt.NewsMgmt;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 建立表结构
 */
public class StructureCommand implements Command{
    @Override
    public void execute() {
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
            String sql = "create table news(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT COMMENT '新闻id'," +
                    "title VARCHAR(20) NOT NULL UNIQUE COMMENT '新闻标题'," +
                    "content VARCHAR(1000) NOT NULL COMMENT '新闻内容'," +
                    "create_time DATE NOT NULL COMMENT '创建时间')";
            // pstmt
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            conn.commit();
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
            DbUtils.closeConnection(null,pstmt,conn);
        }

    }
}
