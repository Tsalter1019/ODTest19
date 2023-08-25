package com.basicKnowledge;


import java.util.*;
import java.util.stream.Collectors;

public class TryCatchExplains1 {
    public static void main(String[] args) {
        //test();
        test2();

    }
    private static int test(){
        int i=1;

        try {
            i++;//1
            System.out.println("try:" + i);//2
            return i;//3--暂存--6--执行
        } catch (Exception e){
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;//4
            System.out.println("finally:" + i);//5
        }
        return i;//不执行
    }

    private static List<Integer> test2(){
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("finally:" + list);
        }
        return list;
    }
}