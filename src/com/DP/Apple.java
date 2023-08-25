package com.DP;

/**
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 *
 * 0≤m≤10 ，1≤n≤10 。
 *
 * 7 3
 * 8
 */

public class Apple {

    public static void main(String[] args) {
        System.out.println(solution(7,3));
    }

    public static int solution(int m,int n){
        int[][] dp = new int[m+1][n+1];
        for(int j=0;j<=n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j>i){
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                }
            }
        }
        return dp[m][n];
    }
}