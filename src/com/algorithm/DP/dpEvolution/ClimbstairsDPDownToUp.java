package com.algorithm.DP.dpEvolution;

/**
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *每次你可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶？（n 为正整数）
 *
 * 动态规划解法（自底向上）
 */
public class ClimbstairsDPDownToUp {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        System.out.println(fib1(100000000));
        System.out.println(System.currentTimeMillis());
    }

    public static int fib(int n){//1660806223396-1660806222974   422
        int[] arr = new int[n+2];

        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    //-- > 优化   better!!

    public static int fib1(int n){//1660806257617-1660806257492   125
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        int pre1 = 1;
        int pre2 = 2;

        int current = 0;

        for(int i=3;i<=n;i++){
            current = pre1 + pre2;
            pre1 = pre2;
            pre2 = current;
        }
        return current;
    }
}