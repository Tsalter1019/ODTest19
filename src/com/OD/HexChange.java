package com.OD;


import java.util.Scanner;

public class HexChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String b= a.substring(2,a.length());
            System.out.println(hex2decimal(b));
        }
    }
    public static int hex2decimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}