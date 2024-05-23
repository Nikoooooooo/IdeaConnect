package com.wbb.biz;

public interface OrderBiz {
    public void makeOrder(int pid,int num);
    public void makeDinner(String name);
    public int findOrderId(String pname);
}
