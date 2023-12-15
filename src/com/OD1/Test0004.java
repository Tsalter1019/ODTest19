package com.OD1;

import java.util.Scanner;

/**
 * 一天一只顽猴想要从山脚爬到山顶，
 * 途中经过一个有n个台阶的阶梯，
 * 但是这个猴子有个习惯，每一次只跳1步或3步
 * 试问？猴子通过这个阶梯有多少种不同的跳跃方式
 *
 * 输入只有一个数n， 0 < n < 50
 * 代表此阶梯有多个台阶
 *
 * 有多少种跳跃方式
 *
 * 50
 *
 * 122106097
 */
public class Test0004 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int m = sc.nextInt();

        System.out.println(new Test0004().fib1(m));

    }
    public int fib(int m){
        if(m==1 || m==2){
            return 1;
        }
        if(m==3){
            return 2;
        }
        return fib(m-1) + fib(m-3);
    }

    public int fib1(int m){
        int[] arr = new int[m+2];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        for(int i=4;i<=m;i++){
            arr[i] = arr[i-1] + arr[i-3];
        }
        return arr[m];
    }
}
