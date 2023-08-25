package com.DP.dpEvolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：1≤s≤150
 * 进阶：时间复杂度：O(n^3)  空间复杂度：O(n)
 * 输入两个只包含小写字母的字符串
 * 输出一个整数，代表最大公共子串的长度
 * asdfasd
 * werasdfaswer
 * 6
 *
 * addbbccaacbddbbb
 * ddcddcbcdbcbbbdabdcddabddcadbbbbdddabacaadcdcaacd
 * 4
 * 13
 */

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String text1,String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return 0;
    }
    public static boolean isSubstring(String str1,String str2){//判断str1是否是str2的子串
        int n = str2.length();
        int i=0;
        for(int j=0;j<n;j++){
            if(str2.charAt(j)==str1.charAt(i)){
                i++;
            }else{
                i=0;
            }
        }
        if(i==str1.length()){
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text1 = br.readLine();
        String text2 = br.readLine();
        //System.out.println(isSubstring(text1,text2));
        System.out.println(longestCommonSubstring(text1,text2));
    }
}