package com.example.test2;

public class Pet {
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void eat(){
        System.out.println(nickName+":吃东西");
    }
}
