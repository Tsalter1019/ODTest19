package com.OD;

/**
 * 反转字符串单词--自己解法
 */


import java.util.Scanner;

public class FanzhuanzifuchaundanciLocal2 {
    private static String solution(String s){
        String [] m = s.split("\\s+");
        String ans = "";
        if(!m[m.length-1].isEmpty()){
            for(int i=m.length-1;i>0;i--){
                ans+=m[i]+" ";

            }
        }

        if(!m[0].isEmpty()){
            ans+=m[0];
        }

        String [] aa = ans.split("\\s+");
        String syout = "";
        if(aa.length>=2){
            for(int j=0;j<=aa.length-2;j++){
                syout+=aa[j]+" ";
            }
        }
        syout = syout + aa[aa.length-1];
        return syout;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(solution(a));
    }
}