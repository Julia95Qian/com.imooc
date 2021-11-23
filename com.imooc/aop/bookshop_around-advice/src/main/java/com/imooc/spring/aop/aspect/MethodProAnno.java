package com.imooc.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class MethodProAnno {
    @Before("execution(* com.imooc..*ShopAnno.*(..))")
    public void preSales(JoinPoint joinPoint) throws Throwable{
        try {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String now = simpleDateFormat.format(new Date());
            System.out.println("======" + now + ":" + className + "." + methodName);
            System.out.println("======Before Selling======");
        } catch (Throwable throwable) {
            System.out.println("Exception message:" + throwable.getMessage());
            throw throwable;
        }
    }
    @After("execution(* com.imooc..*ShopAnno.*(..))")
    public void afterSales(JoinPoint joinPoint) throws Throwable{
        try {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String now = simpleDateFormat.format(new Date());
            System.out.println("======" + now + ":" + className + "." + methodName);
            System.out.println("======After Selling======");
        } catch (Throwable throwable) {
            System.out.println("Exception message:" + throwable.getMessage());
            throw throwable;
        }
    }
}
