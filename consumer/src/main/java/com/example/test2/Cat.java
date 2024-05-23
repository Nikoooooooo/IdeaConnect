package com.example.test2;

public class Cat extends Pet{

    @Override
    public void eat() {
        System.out.println("猫吃罐头");
    }

    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }

}
