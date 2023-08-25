package com.DP.dpEvolution;

/**
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *每次你可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶？（n 为正整数）
 *
 *递归的暴力解法
 */
public class Alex {
    private static int fib(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}