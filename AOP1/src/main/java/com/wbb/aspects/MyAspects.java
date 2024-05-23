
package com.wbb.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

@Component
@Aspect
public class MyAspects {
    @Pointcut("execution(* com.wbb.biz.*.make*(..))")
    private void a(){

    }

    @Before("a()")
    public void recordTime(){
        LocalDateTime time=LocalDateTime.now();
        System.out.println("下单时间为===="+time);
    }

    @AfterReturning("a()")
    public void sendEmail(){
        System.out.println("发送邮件");
    }


    @AfterReturning("a()")
    public void recordParams(JoinPoint jp){
        System.out.println("增强的方法是:"+jp.getSignature());
        System.out.println("增强的目标类"+jp.getTarget());
        System.out.println("参数:");
        Object[] params=jp.getArgs();
        for (Object o:params){
            System.out.println(o);
        }
    }
    @AfterThrowing(pointcut = "a()",throwing = "ex")
    public void throwEx(JoinPoint jp,RuntimeException ex){
        System.out.println("=================");
        System.out.println("发生问题"+ex.getMessage());
        System.out.println("=================");
        System.out.println("第一个参数为:"+jp.getArgs()[0]+"第二个参数为:"+jp.getArgs()[1]);
        System.out.println("=================");
    }

    @Around("a()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object returnValue=pjp.proceed();
        long endTime=System.currentTimeMillis();
        System.out.println("方法使用时间:"+(endTime-startTime));
        return returnValue;
    }
}
