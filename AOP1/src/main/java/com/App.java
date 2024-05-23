package com;

import com.wbb.Config;
import com.wbb.biz.OrderBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
        OrderBiz ob=ac.getBean(OrderBiz.class);
        ob.makeOrder(1,88);
        //ob.makeDinner("小丽");
    }
}
