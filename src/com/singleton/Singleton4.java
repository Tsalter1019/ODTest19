package com.singleton;

/**
 * 线程安全 lazy初始化
 * 双重校验锁 double-checked locking
 */

public class Singleton4 {
    private volatile static Singleton4 singleton4;
    private Singleton4 (){}
    public static  Singleton4 getSingleton4(){
        if(singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}