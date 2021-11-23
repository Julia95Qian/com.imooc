package com.imooc.spring.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookShopAnno {
    public void sellingBooks() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sold out a book");
    }
}
