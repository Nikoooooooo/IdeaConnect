package com.example.test2;

public class Dog extends Pet{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void watchHouse(){
        System.out.println("狗看家");
    }
}
