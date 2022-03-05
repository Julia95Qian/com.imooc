package com.library.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.library.entity.Book;
import com.library.entity.Evaluation;
import com.library.entity.MemberReadState;
import com.library.mapper.BookMapper;
import com.library.mapper.EvaluationMapper;
import com.library.mapper.MemberReadStateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("bookService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BookService implements IBookService{
    @Resource
    private BookMapper bookMapper;
    @Resource
    private MemberReadStateMapper memberReadStateMapper;
    @Resource
    private EvaluationMapper evaluationMapper;
    @Override
    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows, String bookNameWord, String subNameWord, String authorNameWord) {
        Page<Book> p = new Page<Book>(page, rows);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>();
        if(categoryId != null && categoryId != -1){
            queryWrapper.eq("category_id", categoryId);
        }
        if(order != null){
            if(order.equals("quantity")){
                queryWrapper.orderByDesc("evaluation_quantity");
            }else if(order.equals("score")){
                queryWrapper.orderByDesc("evaluation_score");
            }
        }
        queryWrapper.like("book_name", bookNameWord);
        queryWrapper.like("sub_title", subNameWord);
        queryWrapper.like("author", authorNameWord);
        IPage<Book> bookPage = bookMapper.selectPage(p, queryWrapper);
        return bookPage;
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Override
    public Book selectById(Long bookId) {
        Book book = bookMapper.selectById(bookId);
        return book;
    }

    @Override
    @Transactional
    public Book updateBook(Book book) {
        bookMapper.updateById(book);
        return book;
    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        bookMapper.deleteById(bookId);
        QueryWrapper<MemberReadState> memberReadStateQueryWrapper = new QueryWrapper<MemberReadState>();
        memberReadStateQueryWrapper.eq("book_id", bookId);
        memberReadStateMapper.delete(memberReadStateQueryWrapper);
        QueryWrapper<Evaluation> evaluationQueryWrapper = new QueryWrapper<Evaluation>();
        evaluationQueryWrapper.eq("book_id", bookId);
        evaluationMapper.delete(evaluationQueryWrapper);
    }
}
