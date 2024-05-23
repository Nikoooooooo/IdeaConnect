package com.wbb.biz;

import org.springframework.stereotype.Service;

@Service
public class OrderBizImpl implements OrderBiz{

    @Override
    public void makeOrder(int pid, int num) {
        if (num>100){
            throw new RuntimeException("商品数量过多");
        }
        System.out.println("makeOrder的方法调用:下订:"+pid+"\t"+num);
    }

    @Override
    public void makeDinner(String name) {
        System.out.println(name+"去做晚餐了");
    }

    @Override
    public int findOrderId(String pname) {
        System.out.println("findOrderId根据商品名:"+pname+"\t查找商品对应的订单号");
        return 2;
    }
}
