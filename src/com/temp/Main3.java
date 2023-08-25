package com.temp;

import java.util.Scanner;

/**
 * 骰子是一个正方体，每个面有一个数字，初始为左1，右2，前3，
 * 后4，上5，下6，用123456表示这个状态，放置在平面上，
 * 可以向左翻转（用L表示向左翻转1次）；可以向右翻转（用R表示
 * 向右翻转1次）；可以向前翻转（用F表示向前翻转1次）；可以向
 * 后翻转（用B表示向后翻转1次）；可以逆时针翻转（用A表示向逆
 * 时针翻转1次）；可以向顺时针翻转（用C表示向顺时针翻转1次）
 * ；
 *
 */
public class Main3 {

    static StringBuffer sb = new StringBuffer("123456");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] op = sc.nextLine().split(" ");
        for(String c: op){
            solution(c.charAt(0));
        }
        System.out.println(sb);
    }

    public static void solution(char a) {
        switch (a){
            case 'L':
                String str1 = new StringBuffer(sb.substring(0,2)).reverse().toString();
                sb.replace(0,2,sb.substring(4,6)).replace(4,6,str1);
                break;
            case 'R':
                String str2 = new StringBuffer(sb.substring(4,6)).reverse().toString();
                sb.replace(4,6,sb.substring(0,2)).replace(0,2,str2);
                break;
            case 'F':
                String str3 = new StringBuffer(sb.substring(2,4)).reverse().toString();
                sb.replace(2,4,sb.substring(4,6)).replace(4,6,str3);
                break;
            case 'B':
                String str4 = new StringBuffer(sb.substring(4,6)).reverse().toString();
                sb.replace(4,6,sb.substring(2,4)).replace(2,4,str4);
                break;
            case 'A':
                String str5 = new StringBuffer(sb.substring(2,4)).reverse().toString();
                sb.replace(2,4,sb.substring(0,2)).replace(0,2,str5);
                break;
            case 'C':
                String str6 = new StringBuffer(sb.substring(0,2)).reverse().toString();
                sb.replace(0,2,sb.substring(2,4)).replace(2,4,str6);
                break;

        }
    }
}