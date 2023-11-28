package Deke.reviewed;

import java.util.HashMap;
import java.util.Map;

/**
  输入一串字符串 字符串长度不超过100 查找字符串中相同字符连续出现的最大次数
  输入描述
    输入只有一行，包含一个长度不超过100的字符串
  输出描述
    输出只有一行，输出相同字符串连续出现的最大次数
   说明：
     输出
   示例1：
     输入
       hello
     输出
       2
    示例2：
      输入
       word
      输出
       1
     示例3：
      输入
        aaabbc
       输出
        3
    字符串区分大小写
   */

public class E75 {
     public static void main(String[] args) {
         System.out.println(solution2("abbcccddddeeeeeffffffggggggghiijjjkkkklllllmmmmmmnnnnnnnoppqqqrrrrssssstttttt"));
     }
     public static int solution2(String s){
         int max = 0;
        char[] ch = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i])){
                map.put(ch[i],map.get(ch[i]) + 1);
            }else{
                map.put(ch[i],1);
            }
        }
        for(Map.Entry mapE:map.entrySet()){
            System.out.println(mapE.getKey()+"--"+mapE.getValue());
        }
        return max;
     }
     public static int solution(String s){
         int max =1;
         int count=1;
         int end=0;
         for(int i=0;i<s.length()-1;i++){
             for(int j=i+1;j<s.length();j++){
                 if(s.charAt(i)==s.charAt(j)){
                     count++;
                     //用于后续结束外层循环的标志
                     end = j;
                 }else{
                     if(count>max){
                         max = count;
                     }
                     i = j-1;
                     count =1;
                     break;
                 }
             }
            if(end==s.length()-1&&count>max){
                max = count;
                break;
            }
         }
         return max;
     }

     public static int solution1(String s){
         char[] chars = s.toCharArray();
         int maxLen = 0;

         for (int i = 0; i < chars.length; i++) {
             int index = i;
             int len = 1;
             while (index + 1 < chars.length && chars[index + 1] == chars[index]) {
                 len++;
                 index++;
             }
             if (len > maxLen) maxLen = len;
             i = index;
         }

         return maxLen;

     }
}
