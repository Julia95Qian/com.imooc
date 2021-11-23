package com.imooc.spring.aop.dao;

public class BookShop {
    public void sellingBooks() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sold out a book");
   }
}