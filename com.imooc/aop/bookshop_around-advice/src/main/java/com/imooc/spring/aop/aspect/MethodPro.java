package com.imooc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodPro {
    public Object welcome(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try {
            String className = proceedingJoinPoint.getClass().getName();
            String methodName = proceedingJoinPoint.getSignature().getName();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String now = simpleDateFormat.format(new Date());
            System.out.println("======" + now + ":" + className + "." + methodName);
            System.out.println("welcome to bookshop");
            Object ret = proceedingJoinPoint.proceed();
            System.out.println("see you next time~");
            return ret;
        } catch (Throwable throwable) {
            System.out.println("Exception message:" + throwable.getMessage());
            throw throwable;
        }
    }
}
