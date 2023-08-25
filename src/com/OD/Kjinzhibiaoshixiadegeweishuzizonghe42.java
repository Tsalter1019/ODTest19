package com.OD;

/**
 * K进制下的各位数字总和
 */

import java.util.Scanner;

public class Kjinzhibiaoshixiadegeweishuzizonghe42 {
    public static int sumBase(int n, int k) {
        int sum = 0;
        while(n!=0){
            sum+=n%k;
            n=n/k;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBase(34,2));

    }
}