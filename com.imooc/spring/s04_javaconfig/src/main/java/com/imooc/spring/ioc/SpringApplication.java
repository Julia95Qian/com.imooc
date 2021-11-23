package com.imooc.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        // ����Java config����IoC�����ĳ�ʼ��
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String[] ids = applicationContext.getBeanDefinitionNames();
        for(String id:ids){
            System.out.println(id + ":" + applicationContext.getBean(id));
        }
    }
}
