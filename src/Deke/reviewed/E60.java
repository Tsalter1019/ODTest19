package Deke.reviewed;

import java.util.LinkedList;
import java.util.List;

/**
    游戏规则：
    输入一个只包含英文字母的字符串,
    字符串中的两个字母如果相邻且相同,就可以消除。
    在字符串上反复执行消除的动作,
    直到无法继续消除为止,此时游戏结束。
    输出最终得到的字符串长度.

    输入描述：
      输入原始字符串str
      只能包含大小写英文字母,字母的大小写敏感,
      str长度不超过100

     输出描述
      输出游戏结束后,最终得到的字符串长度

      示例一：
      输入
        gg

      输出
        0
        说明 gg可以直接消除 得到空串 长度为0

      示例2
      输入：
        mMbccbc
        0123456
      输出
        3
       说明mMbccbc中 可以先消除cc 此时变为mMbbc
       再消除 bb 此时变成mMc
       此时没有相同且相邻的字符 无法继续消除
       最终得到字符串mMc  长度为3

      备注：
       输入中包含非大小写英文字母时
       均为异常输入
       直接返回0
     */
public class E60 {
    public static void main(String[] args) {
        System.out.println(solution("mMbccbc"));
    }
    public static int solution(String str){
        char[] ch = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        String aa = "";
        int count=0;
        List<Character> list = new LinkedList<>();
        for(int i=0;i<ch.length;i++){
            list.add(ch[i]);
        }
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                list.remove(i);
                list.remove(i);
                break;
            }
        }
        for(int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i));
        }
        aa  = stringBuilder.toString();
        for(int i=0;i<aa.length()-1;i++){
            if(aa.charAt(i)==aa.charAt(i+1)){
                count++;
            }
        }
        if(count>0){
            return solution(aa);
        }else{
            return aa.length();
        }
    }
}
