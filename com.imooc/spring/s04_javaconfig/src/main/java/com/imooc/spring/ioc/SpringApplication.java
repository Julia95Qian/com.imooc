package com.imooc.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        // 基于Java config配置IoC容器的初始化
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String[] ids = applicationContext.getBeanDefinitionNames();
        for(String id:ids){
            System.out.println(id + ":" + applicationContext.getBean(id));
        }
    }
}
