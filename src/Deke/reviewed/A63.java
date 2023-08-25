package Deke.reviewed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
    给定两个字符集合 一个是全量字符集 一个是已占用字符集 已占用字符集中的字符不能再使用 要求输出剩余可用字符集
    输入描述
     1. 输入一个字符串 一定包含@  @前为全量字符集  @后的为已占用字符集
     2. 已占用字符集中的字符 一定是全量字符集中的字符 字符集中的字符跟字符之间使用英文逗号隔开
     3. 每个字符都表示为字符+数字的形式 用英文冒号分隔 比如a:1标识一个a字符
     4. 字符只考虑英文字母，区分大小写 数字只考虑正整型 不超过100
     5. 如果一个字符都没被占用 @标识仍存在 例如 a:3,b:5,c:2@
     输出描述：
       输出可用字符集 不同的输出字符集之间用回车换行 注意 输出的字符顺序要跟输入的一致 不能输出b:3,a:2,c:2 如果某个字符已全部占用 则不需要再输出
      示例一：
       输入
       a:3,b:5,c:2@a:1,b:2
       输出
       a:2,b:3,c:2
       说明：
       全量字符集为三个a，5个b，2个c
       已占用字符集为1个a，2个b
       由于已占用字符不能再使用
       因此剩余可用字符为2个a，3个b，2个c
       因此输出a:2,b:3,c:2
     */
public class A63 {
    public static void main(String[] args) {
        System.out.println(solution("a:15,b:5,c:2@a:1,b:2"));
    }
    public static String solution(String str){
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        String[] arr = str.split("@");
        String[] str1 = arr[0].split(",");
        String[] str2 = arr[1].split(",");
        for(int i=0;i<str1.length;i++){
            String[] temp = str1[i].split(":");
            char ch = temp[0].charAt(0);
            int num = Integer.parseInt(temp[1]);
            map1.put(ch,num);
        }
        for(int i=0;i<str2.length;i++){
            String[] temp = str2[i].split(":");
            char ch = temp[0].charAt(0);
            int num = Integer.parseInt(temp[1]);
            map2.put(ch,num);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Character c : map2.keySet()) {
            if(map1.keySet().contains(c)){
                map1.put(c,map1.get(c)-map2.get(c));
            }

        }
        for(Character c:map1.keySet()){
            stringBuilder.append(c+":"+map1.get(c)+",");
        }

        return stringBuilder.substring(0,stringBuilder.length()-1);
    }


}