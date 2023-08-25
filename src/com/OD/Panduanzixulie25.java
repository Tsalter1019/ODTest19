package com.OD;

/**
 * 判断子序列
 */
public class Panduanzixulie25 {
    public boolean isSubsequence(String s, String t) {
        int n=s.length(),m=t.length();
        int i=0,j=0;
        while(i<n&&j<m){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==n;
    }
}