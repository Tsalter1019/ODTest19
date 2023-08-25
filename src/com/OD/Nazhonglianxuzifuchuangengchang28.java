package com.OD;

import java.util.Scanner;

/**
 * 哪种连续字符串更长
 */

public class Nazhonglianxuzifuchuangengchang28 {
    public static boolean checkZeroOnes(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        int oneMax = 0;
        int zeroMax = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                oneCount++;
            } else {
                oneMax = Math.max(oneMax,oneCount);
                oneCount=0;
            }

        }
        oneMax = Math.max(oneMax,oneCount);
        for(int j = 0; j<s.length(); j++){
            if(s.charAt(j)=='0'){
                zeroCount++;
            } else {
                zeroMax = Math.max(zeroMax,zeroCount);
                zeroCount=0;
            }
        }
        zeroMax = Math.max(zeroMax,zeroCount);
        if(oneMax>zeroMax){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(checkZeroOnes(str));
    }
}