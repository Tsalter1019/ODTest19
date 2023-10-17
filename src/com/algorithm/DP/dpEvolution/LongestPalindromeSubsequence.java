package com.algorithm.DP.dpEvolution;

/**
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 */
public class LongestPalindromeSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        //dp[0][m-1] 为答案
        //初始化
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j) dp[i][j] =1;
                else dp[i][j]=0;
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=1;j<=m-1;j++){
                if(i<j){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }}
        }
        return dp[0][m-1];
    }
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

}