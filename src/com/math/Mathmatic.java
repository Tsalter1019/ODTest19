package com.math;

import java.util.Scanner;

public class Mathmatic{

    private static int solution(int a){
        int out=0;
        for(int i=1;i<=a;i++){
            if(isCompleteNum(i)){
                out++;
            }
        }
        return out;
    }
    private static boolean isCompleteNum(int b){
        int num=0;
        for(int j=1;j<b;j++){
            if(b%j==0){
                num+=j;
            }
        }
        if(num==b){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(solution(m));
    }
}