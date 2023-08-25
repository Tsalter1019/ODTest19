package com.OD;

/**
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 * bc
 * abc
 * true
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shifoubaohan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(solution(a,b));
    }
    public static boolean solution(String a,String b){
        int count=0;
        char[] ch = a.toCharArray();

            for(int j=0;j<ch.length;j++){
                if(b.contains(ch[j]+"")){
                    count++;
                }
            }
            if(count==a.length()){
                return true;
            }else{
                return false;
            }


    }
}