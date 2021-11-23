package com.imooc.spring.ioc;

import com.imooc.spring.ioc.entity.Cat;
import com.imooc.spring.ioc.entity.Dog;
import com.imooc.spring.ioc.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.testClothes();
    }
    public void testCatNDog(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Cat cat = applicationContext.getBean("cat", Cat.class);
        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println(cat);
        System.out.println(dog);
    }
    public void testClothes(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Person girl = applicationContext.getBean("girl", Person.class);
        girl.dress();
        Person boy = applicationContext.getBean("boy", Person.class);
        boy.dress();
    }
}

