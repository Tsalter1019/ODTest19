package com.OD1;

import java.util.Scanner;

/**
 * 输入一个英文文章片段，
 * 翻转指定区域的单词顺序，
 * 标点符号和普通字母一样处理，
 * 例如输入字符串
 * I am a developer.
 * [0,3]
 * 则输出
 * developer. a am I
 *
 * 使用换行隔开3个参数
 * 第一个参数为文章内容 即英文字符串
 * 第二个参数为翻转起始单词下标，下标从0开始
 * 第三个参数为结束单词下标
 *
 * I am a developer.
 * 0
 * 3
 *
 * developer. a am I
 *
 * hello world!
 * 0
 * 3
 *
 * world! hello
 *
 * a b c d e f
 * 1
 * 4
 *
 * a e d c b f
 */
public class Test0007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int m = sc.nextInt();
        int n = sc.nextInt();
        String [] arr = str.split("\\s+");

        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            if(m>i){
                stringBuffer.append(arr[i]).append(" ");
            }else if(i>=m && i<=n){
                while(m<=n){
                    if(n>arr.length){
                        n = arr.length-1;
                    }
                    stringBuffer.append(arr[n]).append(" ");
                    i++;
                    n--;
                }
                i--;
            }else{
                stringBuffer.append(arr[i]).append(" ");
            }
        }

        System.out.println(stringBuffer.substring(0,stringBuffer.length()-1));
    }
}