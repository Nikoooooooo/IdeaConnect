package com.example.test;

public class GetTicket {
    private int TicketNum=10;
    static Object lock=new Object();

    public  void getTicket(){
        synchronized (lock){
            if (TicketNum<=0){
                return;
            }
            System.out.println(Thread.currentThread().getName()+":抢到了票,剩余票数"+TicketNum);
            TicketNum--;
        }
    }

    public static void main(String[] args) {
        GetTicket gt=new GetTicket();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                gt.getTicket();
            }).start();
        }
    }
}
