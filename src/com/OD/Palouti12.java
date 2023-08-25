package com.OD;

import java.util.Scanner;

/**
 * 爬楼梯
 */

public class Palouti12 {
    public static int climbStairs(int n) {
        int p=0, q=0, r=1;
        for(int i=0;i<=n;i++){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(climbStairs(m));
    }
}