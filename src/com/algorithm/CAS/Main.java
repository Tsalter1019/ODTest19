package com.algorithm.CAS;


import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //轮子
    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread name:" + Thread.currentThread().getName()+ ":" + num.incrementAndGet());
                }
            });
            t.start();
        }
    }
}