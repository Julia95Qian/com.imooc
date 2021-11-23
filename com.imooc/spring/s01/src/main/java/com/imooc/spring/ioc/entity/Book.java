package com.imooc.spring.ioc.entity;

public class Book {
    private int number;
    private String name;
    private float price;

    public Book() {
        System.out.println("book对象通过默认构造方法创建" + this);
    }

    public Book(int number, String name, float price) {
        System.out.println("book对象通过带参构造方法创建" + this);
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
