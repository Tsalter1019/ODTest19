package Deke;

/**
        给定一个字符串S

        变化规则:
         交换字符串中任意两个不同位置的字符
        12345  56321
        输入描述：
         一串小写字母组成的字符串
        输出描述：
         按照要求变换得到最小字符串

        实例1：
         输入：、
         abcdef
        输出
         abcdef

        实例2：
         输入
         bcdefa
         输出
         acdefb

        s都是小写字符组成
        1<=s.length<=1000
         */
public class A67 {
    public static void main(String[] args) {
        System.out.println(solution("bcdefa"));

    }
    //bczzz
    public static String solution(String str){
        char[] ch = str.toCharArray();
        String tt = str;
        String out="";
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                tt = returnChange(str,i,j);
                if(whichSmaller(tt,str)){
                    out = tt;
                }
            }
        }
        return out;
    }
    public static String returnChange(String temp,int i,int j){
        char[] ch = temp.toCharArray();
        String result="";
        char  kk = ch[i];
        ch[i] = ch[j];
        ch[j] = kk;
        for(int m=0;m<ch.length;m++){
            result+=ch[m];
        }
        return result;
    }
    //第一个值小于第二个返回true
    public static boolean whichSmaller(String str1,String str2){
        for(int i=0;i<str1.length();i++){
            for(int j=i;j<str2.length();j++){
                if(str1.charAt(i)<str2.charAt(j)){
                    return true;
                }
                if(str1.charAt(i)==str2.charAt(j)){
                    break;
                }
                if(str1.charAt(i)>str2.charAt(j)){
                    return false;
                }
            }
        }
        return false;
    }
}