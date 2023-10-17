package com.dataStructure.singleton;

/**
 * 线程安全 lazy初始化
 * 静态内部类
 */

public class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    private Singleton5 (){}
    public static final Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}