package com.imooc.oa.utils;

import org.junit.Test;

public class MybatisUtilsTestor {
    @Test
    public void testSelect(){
        String result = (String) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(result);
    }
}
