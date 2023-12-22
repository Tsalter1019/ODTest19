package com.OD1;

import java.util.Scanner;

/**
 * 为了充分发挥GPU算力，
 * 需要尽可能多的将任务交给GPU执行，
 * 现在有一个任务数组，
 * 数组元素表示在这1s内新增的任务个数，
 * 且每秒都有新增任务，
 * 假设GPU最多一次执行n个任务，
 * 一次执行耗时1s，
 * 在保证GPU不空闲的情况下，最少需要多长时间执行完成。
 *
 * 第一个参数为GPU最多执行的任务个数，取值范围1 ~ 10000
 * 第二个参数为任务数组的长度，取值范围1 ~ 10000
 * 第三个参数为任务数组，数字范围1 ~ 10000
 *
 * 执行完所有任务需要多少秒
 *
 * 3
 * 5
 * 1 2 3 4 5
 *
 * 6
 *
 * 4
 * 5
 * 5 4 1 1 1
 *
 * 5
 */
public class Test0005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }





    }

}
