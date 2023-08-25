package com.OD;

/**
 * 将一个字符串中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 *
 * 数据范围：字符串长度满足 1≤n≤100
 * 输入一个字符串
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * Jkdi234klowe90a3
 * Jkdi*234*klowe*90*a*3*
 */
public class Biaoshishuzi96 {
    public static void main(String[] args) {
        System.out.println(solution("1**3"));
    }
    public static String solution(String s){
        char[] ch = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<ch.length-1;i++){
            if((!Character.isDigit(ch[i])&&!Character.isDigit(ch[i+1]))&&(Character.isDigit(ch[i])&&Character.isDigit(ch[i+1]))){
                stringBuilder.append(ch[i]);
            }else if((!Character.isDigit(ch[i])&&Character.isDigit(ch[i+1]))||(Character.isDigit(ch[i])&&!Character.isDigit(ch[i+1]))){
                stringBuilder.append(ch[i]);
                stringBuilder.append('*');
            }else if(Character.isDigit(ch[i])){

            }else{
                stringBuilder.append(ch[i]);
            }
        }
        if(Character.isDigit(s.charAt(s.length()-1))){
            stringBuilder.append(s.charAt(s.length()-1)).append('*');
        }else{
            stringBuilder.append(s.charAt(s.length()-1));
        }
        return stringBuilder.toString();
    }
}