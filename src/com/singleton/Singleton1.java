package com.singleton;

/**
 * 懒汉式 线程不安全 lazy初始化
 */

public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1 (){}

    public static Singleton1 getInstance() {
        if(instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 s1 = new Singleton1();
        Singleton1 s2 = null;
        s2 = s1;
        System.out.println(s1);
        System.out.println(s2);
    }
}