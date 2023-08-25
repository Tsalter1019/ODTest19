package Deke;

import java.util.LinkedList;
import java.util.List;

/**
        游戏规则：输入一个只包含英文字母的字符串，
        字符串中的俩个字母如果相邻且相同，就可以消除。
        在字符串上反复执行消除的动作，
        直到无法继续消除为止，
        此时游戏结束。
        输出最终得到的字符串长度。

        输出：原始字符串str只能包含大小写英文字母，字母的大小写敏感，长度不超过100，
        输出游戏结束后字符串的长度

        备注：输入中包含非大小写英文字母是均为异常输入，直接返回0。

        事例：mMbccbc输出为3
         */
public class A69 {
    public static void main(String[] args) {
        System.out.println(solution("mMbccbccM"));
    }
    /*public static int solution(String str){

        String ss = "";
        for(int i=0;i<list.size();i++){
            ss = list.get(i)+"";
        }
        return 1;
    }*/
    public static int solution(String ss){
        List<Character> list = new LinkedList<>();

        char[] ch = ss.toCharArray();
        for(int i=0;i<ch.length;i++){
            list.add(ch[i]);
        }

        String result="";
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i);
                list.remove(i);
                i=0;
            }
        }
        for(int i=0;i<list.size();i++){
            if(list.size()==2&&list.get(0)==list.get(list.size()-1)){
                result="";
            }else{
                result+=list.get(i);
            }

        }

        return result.length();
    }
}