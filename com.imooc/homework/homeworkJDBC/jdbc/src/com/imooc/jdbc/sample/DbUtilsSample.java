package com.imooc.jdbc.sample;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.imooc.jdbc.common.DbUtils;
import com.imooc.jdbc.hrapp.entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Apache DBUtils + Druid联合使用
 */
public class DbUtilsSample {
    public static void query() {
        Properties properties = new Properties();
        String propertyFile = DbUtilsSample.class.getResource("/druid-config.properties").getPath();
        try {
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // 查询执行到某个数据库
            QueryRunner qr = new QueryRunner(ds);
            // 查询sql语句，返回值自动以Employee的方式包装，sql语句中第一个参数设置为10
            List<Employee> list = qr.query("select * from employee limit ?,10",
                    new BeanListHandler<>(Employee.class),
                    new Object[]{10});
            // 循环输出结果
            for(Employee emp:list){
                System.out.println(emp.getEname());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 连接自动关闭

    }
    public static void update(){
        Properties properties = new Properties();
        String propertyFile = DbUtilsSample.class.getResource("/druid-config.properties").getPath();
        Connection conn = null;
        try {
            propertyFile = new URLDecoder().decode(propertyFile, "UTF-8");
            properties.load(new FileInputStream(propertyFile));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update employee set salary=salary+1000 where eno=? ";
            String sql2 = "update employee set salary=salary-1000 where eno=? ";
            QueryRunner qr = new QueryRunner();
            qr.update(conn,sql1,new Object[]{1000});
            qr.update(conn,sql2,new Object[]{1001});
            conn.commit();
        }catch (Exception e){
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

    public static void main(String[] args) {
        DbUtilsSample dus = new DbUtilsSample();
        dus.update();
    }
}
