package com.algorithm.DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckerBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\ ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);

        int[][] dp = new int[m+1][n+1];
        //边界
        for(int i=0;i<=m;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<=n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(dp[m][n]);
    }
}