package com.example.test3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Component
@Aspect
public class AuthAspect {

    @Pointcut("execution(public int com.example.test3.Auth.*(..))")
    public void authCut(){

    }
    @Before("authCut()")
    public void cutProcess(JoinPoint joinPoint){
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        String name=method.getName();
        System.out.println("AOP开始拦截方法,方法名为:"+name);
    }


    @After("authCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        String name=method.getName();
        System.out.println("AOP结束拦截方法,方法名为:"+name);
    }

    @Around("authCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP环绕方法开始");
        Object proceed=joinPoint.proceed();
        System.out.println("AOP环绕方法结束");
        return proceed;
    }

    @AfterReturning(value = "authCut()",returning = "result")
    public void afterReturningOperate(JoinPoint joinPoint,Object result){
        System.out.println("AOP返回结果"+result);
    }





}
