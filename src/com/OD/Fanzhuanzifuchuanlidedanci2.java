package com.OD;

import java.util.Scanner;

/**
 * 反转字符串里的单词
 */

public class Fanzhuanzifuchuanlidedanci2 {


    //public static String solution(String s){
    //
    //}

    public StringBuilder trimSpace(String s){
        int left = 0,right = s.length()-1;
        while(left <= right && s.charAt(left) == ' '){
            ++left;
        }
        while(left <= right && s.charAt(right) == ' '){
            --right;
        }
        StringBuilder sb = new StringBuilder();
        while(left <= right){
            char c = s.charAt(left);
            if(c != ' '){
                sb.append(c);
            }else if(sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb,int left,int right){
        while(left<right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println();
    }
}