package com.OD;


import java.util.Scanner;

public class Zuichanggonggongzichuan {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS (String str1, String str2) {
        // write code here
        int maxLength = 0;
        int maxLastIndex = 0;
        int[] dp = new int[str2.length() + 1];
        for(int i=0;i<str1.length();i++){
            for(int j=str2.length()-1;j>=0;j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[j+1] = dp[j] + 1;
                    if(dp[j+1]>maxLength){
                        maxLength = dp[j+1];
                        maxLastIndex = i;
                    }
                }else{
                    dp[j+1] = 0;
                }
            }
        }
        return str1.substring(maxLastIndex-maxLength+1,maxLastIndex+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(LCS(a,b));
    }
}