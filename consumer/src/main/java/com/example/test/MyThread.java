package com.example.test;

public class MyThread {

    private static Object lock=new Object();
    static volatile   boolean flag=false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag=true;
                System.out.println(Thread.currentThread().getName()+" modify true");
            }

        },"t1").start();

        new Thread(()->{
           synchronized (lock){
               try {
                   lock.wait(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(flag);

           }
        },"t2").start();


        new Thread(()->{
            int i=0;
            while (!flag){
                i++;
            }
            System.out.println("stop num:"+i);

        },"t3").start();








    }

    public static void waitTest() throws InterruptedException {
        Thread t1=new Thread(()->{
            synchronized (lock){
                System.out.println(""+Thread.currentThread().getName()+" waiting");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(""+Thread.currentThread().getName()+" running");
            }

        },"t1");

        t1.start();

        Thread.sleep(10);
        synchronized (lock){

        }


    }






}
