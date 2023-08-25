package com.dayPractise;

import java.util.Scanner;




public class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] strA = str1.split("\\ ");
        int k=Integer.parseInt(strA[1]);
        String[] strB = str2.split("\\ ");
        int [] arr = new int[strB.length];
        for(int i=0;i<strB.length;i++){
            arr[i] = Integer.parseInt(strB[i]);
        }
        for(int m=0;m<arr.length-1;m++){
            for(int n=0;n<arr.length-1-m;n++){
                int temp=0;
                if(arr[n]>arr[n+1]){
                    temp = arr[n];
                    arr[n]=arr[n+1];
                    arr[n+1]=temp;
                }
            }
        }
        String ou = "";
        for(int s=0;s<k-1;s++){
            ou+=arr[s]+" ";
        }
        ou=ou+arr[k-1];
        System.out.println(ou);
    }
}