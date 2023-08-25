package com.OD;


import java.util.Arrays;
import java.util.Scanner;

public class Zifutongji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(characterCount(str));
        }
    }
    public static String characterCount(String str){
        int[][] count = new int[128][2];
        char[] ch = str.toCharArray();
        for(int i = 0; i<128; i++)
            count[i][0] = i;
        for(char c:ch)
            count[c][1]++;
        Arrays.sort(count,(a,b) -> {
            if(a[1] != b[1])
                return b[1]-a[1];
            return a[0]-b[0];
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<128;i++){
            char c  = (char) count[i][0];
            int k = count[i][1];
            while (k-->0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}