package com.imooc.spring.aop;

import com.imooc.spring.aop.dao.BookShop;
import com.imooc.spring.aop.dao.BookShopAnno;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.beforeAfterAdvice();
    }
    public void roundAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookShop bookShop = applicationContext.getBean("bookShop", BookShop.class);
        bookShop.sellingBooks();
    }
    public void beforeAfterAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        BookShopAnno bookShopAnno = applicationContext.getBean("bookShopAnno", BookShopAnno.class);
        bookShopAnno.sellingBooks();
    }
}
