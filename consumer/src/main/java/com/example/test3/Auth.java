package com.example.test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Auth {

    public int add(int num1,int num2){
        System.out.println("进行加法操作");
        return num1+num2;
    }

}
