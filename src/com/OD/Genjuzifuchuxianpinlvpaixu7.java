package com.OD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 根据字符出现频率排序
 */

public class Genjuzifuchuxianpinlvpaixu7 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        int maxFreq = 0;
        //int length = ;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c,0)+1;
            map.put(c,frequency);
            maxFreq = Math.max(maxFreq,frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for(int i=0;i<=maxFreq;i++){
            buckets[i] = new StringBuffer();
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = maxFreq;i>0;i--){
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j =0;j<size;j++){
                for(int k =0;k<i;k++){
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new Genjuzifuchuxianpinlvpaixu7().frequencySort(str));
    }
}