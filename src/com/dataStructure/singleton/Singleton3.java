package com.dataStructure.singleton;

/**
 * 饿汉式 线程安全 不lazy
 */

public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3(){}
    public static Singleton3 getInstance(){
        return instance;
    }
}