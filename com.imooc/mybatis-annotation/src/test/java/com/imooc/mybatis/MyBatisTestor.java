package com.imooc.mybatis;

import com.imooc.mybatis.dao.GoodsDAO;
import com.imooc.mybatis.dto.GoodsDTO;
import com.imooc.mybatis.entity.Goods;
import com.imooc.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTestor {
    @Test
    public void testSelectByPriceRange(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            GoodsDAO goodsDAO = session.getMapper(GoodsDAO.class);
            List<Goods> list = goodsDAO.selectByPriceRange(100f, 500f, 20);
            System.out.println(list.size());
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }
    @Test
    public void testInsert() throws Exception {
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            Goods goods = new Goods();
            goods.setTitle("测试商品");
            goods.setSubTitle("测试子标题");
            goods.setOriginalCost(200f);
            goods.setCurrentPrice(100f);
            goods.setDiscount(0.5f);
            goods.setIsFreeDelivery(1);
            goods.setCategoryId(43);
            GoodsDAO goodsDAO = session.getMapper(GoodsDAO.class);
            // insert()方法返回值代表本次成功插入的记录数
            int num = goodsDAO.insert(goods);
            session.commit();//提交事务数据
            System.out.println(goods.getGoodsId());
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            throw e;
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }
    @Test
    public void testSelectAll() throws Exception{
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            GoodsDAO goodsDAO = session.getMapper(GoodsDAO.class);
            List<GoodsDTO> list = goodsDAO.selectAll();
            System.out.println(list.size());
        }catch (Exception e){
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }
}
