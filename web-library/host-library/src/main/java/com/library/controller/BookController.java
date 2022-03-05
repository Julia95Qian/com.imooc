package com.library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.entity.Book;
import com.library.service.IBookService;
import com.library.service.exception.BusinessException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BookController {
    @Resource
    private IBookService bookService;

    @GetMapping("/")
    public ModelAndView showMainPage(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/books")
    @ResponseBody
    @CrossOrigin
    public Map getBooks(Integer page, Integer limit, String bookNameWord, Long categoryId, String subNameWord, String authorNameWord){
        Map result = new HashMap();
        if(page == null){
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        if(bookNameWord == null){
            bookNameWord = "";
        }
        if(subNameWord == null){
            subNameWord = "";
        }
        if(authorNameWord == null){
            authorNameWord = "";
        }
        IPage<Book> bookIPage = bookService.paging(categoryId, null, page, limit, bookNameWord, subNameWord, authorNameWord);
        result.put("success", true);
        result.put("data", bookIPage);
        return result;
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public Map selectById(@PathVariable("id") Long bookId) {
        Book book = bookService.selectById(bookId);
        Map result = new HashMap();
        result.put("success", true);
        result.put("data", book);
        return result;
    }

    @PostMapping("/addBook")
    @ResponseBody
    public Map addBook(Book book){
        Map result = new HashMap();
        try {
            book.setEvaluationQuantity((float) 0);
            book.setEvaluationScore(0f);
            if(book.getCover() == null){
                book.setCover("");
            }
            bookService.createBook(book);
            result.put("success", true);
            result.put("data", book);
        } catch (BusinessException e) {
            e.printStackTrace();
            result.put("code", e.getCode());
            result.put("cause", e.getCause());
            result.put("success", false);
        }
        return result;
    }

    @PostMapping("/update")
    @ResponseBody
    public Map updateBook(Book book){
        Map result = new HashMap();
        try {
            Book rawBook = bookService.selectById(book.getBookId());
            rawBook.setBookName(book.getBookName());
            rawBook.setSubTitle(book.getSubTitle());
            rawBook.setAuthor(book.getAuthor());
            rawBook.setCategoryId(book.getCategoryId());
            rawBook.setDescription(book.getDescription());
            bookService.updateBook(rawBook);
            result.put("success", true);
            result.put("data", rawBook);
        } catch (BusinessException e) {
            e.printStackTrace();
            result.put("code", e.getCode());
            result.put("cause", e.getCause());
            result.put("success", false);
        }
        return result;
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public Map deleteBook(@PathVariable("id") Long bookId) {
        Map result = new HashMap();
        try {
            bookService.deleteBook(bookId);
            result.put("success", true);
        } catch (BusinessException e) {
            e.printStackTrace();
            result.put("code", e.getCode());
            result.put("cause", e.getCause());
            result.put("success", false);
        }
        return result;
    }

}
