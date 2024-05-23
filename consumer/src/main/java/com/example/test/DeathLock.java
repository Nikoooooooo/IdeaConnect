package com.example.test;

public class DeathLock {
    static Object A=new Object();
    static Object B=new Object();

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" lockA");
            synchronized (A){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(Thread.currentThread().getName()+" lockB");
                }
            }
        },"t1");


        Thread t2=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" lockA");
            synchronized (B){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println(Thread.currentThread().getName()+" lockB");
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
