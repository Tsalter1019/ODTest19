package com.OD;

/**
 * 字符串压缩
 */

import java.util.Scanner;

public class Zifuchuanyasuo {
        public static String compressString(String S) {

        if(S.length() == 0){
            return S;
        }

        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);

        for(int i=1;i<S.length();++i){
            if(ch == S.charAt(i)){
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(compressString(str));
    }
}