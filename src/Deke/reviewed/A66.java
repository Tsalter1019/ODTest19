package Deke.reviewed;

import java.util.LinkedList;
import java.util.List;

/**
    定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
    称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
    并返回其长度，如果找不到请返回0，
    字符串中任意一个连续字符组成的子序列称为该字符串的子串

    输入描述：
      一个字符串其长度 0<length ,字符串仅由字符a-z或A-Z组成
    输出描述：
      一个整数，表示最长的元音字符子串的长度

    示例1：
      输入
        asdbuiodevauuifgh
      输出
        3
      说明：
        最长的元音字符子串为uio和auu长度都为3，因此输出3
     */
public class A66 {
    public static void main(String[] args) {
        System.out.println(solution("asdbuiodevauuifgh"));
    }
    public static int solution(String str){
        int max = 0;
        int count=0;
        List<Character> list = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='A' ||str.charAt(i)=='E'||str.charAt(i)=='I'||str.charAt(i)=='O' ||str.charAt(i)=='U'){
                list.add(str.charAt(i));
                count = list.size();
                if(count>max){
                    max = count;
                }
            }else{
                list.clear();
            }
        }

        return max;
    }
}
