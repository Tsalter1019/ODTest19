package com.OD;

import java.util.Scanner;

/**
 * 只有两个键的键盘  给你一个数字 n ，你需要使用最少的操作次数，
 * 在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 */

public class Zhiyoulianggejiandejianpan36 {
    public static int minSteps(int n) {
        int ans = 0;
        for(int i=2;i*i<=n;++i){
            while(n%i==0){
                n/=i;
                ans+=i;
            }
        }
        if(n>1){
            ans+=n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(minSteps(m));
    }
}