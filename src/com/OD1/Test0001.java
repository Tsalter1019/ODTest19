package com.OD1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 勾股数
 */

/**
 * 题目0001-勾股数
 * 题目描述
 * 如果三个正整数A、B、C ，A² + B² = C² 则为勾股数，
 *
 * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，则称其为勾股数元组。
 *
 * 请求出给定 n ~ m 范围内所有的勾股数元组。
 *
 * 输入描述
 * 起始范围
 *
 * 1 < n < 10000
 *
 * n < m < 10000
 *
 * 输出描述
 * ABC保证A < B < C
 *
 * 输出格式A B C
 *
 * 多组勾股数元组，按照A B C升序的排序方式输出。
 *
 * 若给定范围内，找不到勾股数元组时，输出Na。
 */
public class Test0001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count=0;

        for(int i=n;i<=m;i++){
            for(int j=i+1;j<=m;j++){
                for(int k=j+1;k<=m;k++){
                    if(isPythagorean(i,j,k) && isPrimeNumberThree(i,j,k)){
                        System.out.println(outp(i,j,k));
                        count++;
                    }
                }
            }
        }


        if(count==0){
            System.out.println("Na");
        }

    }
    /*public static void main(String[] args) {
        System.out.println(new Test0001().isPrimeNumber(3,7));
    }*/

    public static String outp(int a,int b,int c){
        String str = "";
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            str=str+list.get(i)+" ";
        }
        return str.substring(0,str.length()-1);
    }

    public static boolean isPythagorean(int a,int b,int c){
        if(a*a+b*b==c*c || a*a+c*c==b*b || c*c+b*b==a*a){
            return true;
        }
        return false;
    }

    public static boolean isPrimeNumber(int a,int b){//判断两个数是否为互质
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a == 1 ? true : false;
    }

    public static boolean isPrimeNumberThree(int a,int b,int c){
        int count=0;
        if(isPrimeNumber(a,b)){
            count++;
        }
        if(isPrimeNumber(a,c)){
            count++;
        }
        if(isPrimeNumber(b,c)){
            count++;
        }
        if(count==3){
            return true;
        }else{
            return false;
        }
    }


}
