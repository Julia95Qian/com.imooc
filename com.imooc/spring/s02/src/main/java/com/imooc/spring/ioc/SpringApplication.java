package com.imooc.spring.ioc;

import com.imooc.spring.ioc.entity.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
        String website = company.getInfo().getProperty("website");
        System.out.println(website);
        /*��ȡ����������beanId����*/
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName: beanNames){
            System.out.println(beanName);
            System.out.println("����" + context.getBean(beanName).getClass().getName());
            System.out.println("����" + context.getBean(beanName).toString());
        }
    }
}
