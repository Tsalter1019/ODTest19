package com.DP.dpEvolution;

/**
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *每次你可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶？（n 为正整数）
 *
 * 带备忘录的解法（自顶向下）
 */
public class ClimbstairsUptoDown {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    private static int fib(int n){
        int[] arr = new int[n+1];
        return helper(arr,n);
    }
    public static int helper(int[] arr,int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        System.out.println("ss");
        arr[n] = helper(arr,n-1)+helper(arr,n-2);
        return arr[n];
    }
}