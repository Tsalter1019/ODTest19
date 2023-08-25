package com.OD;

import java.util.*;

/**
 * 给定一个字符串，找出不含有重复的最长子串的长度
 * 给定 “abcabcbb” ，没有重复字符的最长子串是 “abc” ，
 * 那么长度就是3。
 *
 * 给定 “bbbbb” ，最长的子串就是 “b” ，长度是1。
 *
 * 给定 “pwwkew” ，最长子串是 “wke” ，长度是3。
 * 请注意答案必须是一个子串，”pwke” 是 子序列 而不是子串。
 */

public class Zuichangbuchongfuzichuan {
    public static int lengthOfLongestSubstring(String s){
        int res = 0, tmp = 0;
        for(int j=0;j<s.length();j++){
            int i=j-1;
            while(i>=0&&s.charAt(i) != s.charAt(j))
                i--;
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }
}