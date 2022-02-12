package com.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.entity.Book;

public interface IBookService  {
    /*
     * 分页查询图书
     * @param categoryId 分类编号
     * @param order 排序规则
     * @param page 页号
     * @param rows 每页记录数
     * @return 分页对象
     * */
    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows);

}
