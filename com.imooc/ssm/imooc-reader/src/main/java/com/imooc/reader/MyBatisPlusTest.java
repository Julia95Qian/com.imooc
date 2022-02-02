package com.imooc.reader;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.reader.entity.Test;
import com.imooc.reader.mapper.TestMapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyBatisPlusTest {
    @Resource
    private TestMapper testMapper;
    @org.junit.Test
    public void testInsert(){
        Test test = new Test();
        test.setContent("MyBatis Plus Testing");
        testMapper.insert(test);
    }
    @org.junit.Test
    public void testUpdate(){
        Test test = testMapper.selectById(9);
        test.setContent("MyBatis Plus TestingUpdate");
        testMapper.updateById(test);
    }
    @org.junit.Test
    public void testDelete(){
        testMapper.deleteById(9);
    }
    public void testSelect(){
        QueryWrapper<Test> queryWrapper = new QueryWrapper<Test>();
//        queryWrapper.eq("id", 7); // 查询 id = 7 数据
        queryWrapper.gt("id", 5); // 查询 id > 5 数据
        List<Test> list = testMapper.selectList(queryWrapper);
        System.out.println(list.get(0));
    }
}
