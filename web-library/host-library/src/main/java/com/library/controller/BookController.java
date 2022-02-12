package com.library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.entity.Book;
import com.library.service.BookService;
import com.library.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/books")
    @ResponseBody
    @CrossOrigin
    public Map getBook(Integer page, Integer limit){
        Map result = new HashMap();
        if(page == null){
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        IPage<Book> bookIPage = bookService.paging(null, null, page, limit);
        result.put("success", true);
        result.put("data", bookIPage);
        return result;
    }
}
