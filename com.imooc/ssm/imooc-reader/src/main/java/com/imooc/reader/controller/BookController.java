package com.imooc.reader.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.*;
import com.imooc.reader.service.BookService;
import com.imooc.reader.service.CategoryService;
import com.imooc.reader.service.EvaluatioinService;
import com.imooc.reader.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {

    @Resource
    private CategoryService categoryService;
    @Resource
    private BookService bookService;
    @Resource
    private EvaluatioinService evaluatioinService;
    @Resource
    private MemberService memberService;

    /*显示首页*/
    @GetMapping("/")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        modelAndView.addObject("categoryList", categoryList);
        System.out.println("-----" + categoryList);
        return modelAndView;
    }
    /*分页查询图书列表*/
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(Long categoryId, String order, Integer p){
        if(p == null){
            p = 1;
        }
        IPage<Book> bookIPage = bookService.paging(categoryId, order, p,10);
        return bookIPage;
    }

    @GetMapping("/book/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id, HttpSession session){
        Book book = bookService.selectById(id);
        List<Evaluation> evaluationList = evaluatioinService.selectByBookId(id);
        Member member = (Member) session.getAttribute("loginMember");
        ModelAndView modelAndView = new ModelAndView("/detail");
        if(member != null){
            //获取会员阅读状态
            MemberReadState memberReadState = memberService.selectMemberReadState(member.getMemberId(), id);
            modelAndView.addObject("memberReadState", memberReadState);
        }

        modelAndView.addObject("book", book);
        modelAndView.addObject("evaluationList", evaluationList);
        return modelAndView;
    }
}
