package com.imooc.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
/**
 * MyBatisUtils工具类，创建全局唯一的SqlSessionFactory对象
 */
public class MyBatisUtils {
    // 利用static(静态)属于类不属于对象，且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;
    // 初始化类时实例化sqlSessionFactory
    static{
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            //初始化错误时，通过抛出异常ExceptionInInitializerError通知
            throw new ExceptionInInitializerError(e);
        }
    }
    /**
     * openSession创建新的SqlSession对象
     * @return SqlSession对象
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
    /**
    * 释放一个有效的SqlSession对象
     * @param session 准备释放的SqlSession对象
    */
    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}