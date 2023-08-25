package Deke;

import java.util.LinkedList;
import java.util.List;

/** 相对开音节构成的结构为辅音+元音(aeiou)+辅音(r除外)+e 常见的单词有bike cake 给定一个字符串，以空格为分隔符 反转每个单词的字母
 若单词中包含如数字等其他非字母时不进行反转 反转后计算其中含有相对开音节结构的子串个数 (连续子串中部分字符可以重复)
         输入描述
            字符串 以空格分割的多个单词
            长度<10000 字母只考虑小写

         输出描述
             含有相对开音节结构的子串个数

         示例1：
            输入
              ekam a ekac
            输出
              2
            说明：
             反转后为  make a cake 其中make和cake为相对开音节子串
             返回2

          示例2：
             输入
                !ekam a ekekac
             输出
                 2
             说明
                 反转后为 !ekam a cakeke
                 因为!ekam含有非英文字母，所以未反转
                 其中 cake和keke 为相对开音节子串 返回2

         */
public class A47 {
    public static void main(String[] args) {
        String ss = "cakeke";

        //System.out.println("cakeke".substring());
        System.out.println(solution("!ekam a ekekekac"));
    }
    public static int solution(String str){
        int count=0;
        List<String> list = new LinkedList<>();

        String[] strings = str.split("\\ ");
        for(int i=0;i<strings.length;i++){
            if(alterh(strings[i])){
                list.add(strings[i]);
            }else{
                list.add(new StringBuffer(strings[i]).reverse().toString());
            }
        }
        for(int i=0;i<list.size();i++){
            count+=sss(list.get(i));
        }
        return count;
    }

    public static int sss(String str){
        int count=0;
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='e'&&i>=3){
                if(isOpenSyllables(str.substring(i-3,i+1))){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean alterh(String str){
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(!(ch[i]>='a'&&ch[i]<='z')){
                return true;
            }
        }
        return false;
    }

    public static boolean isOpenSyllables(String str){
        char[] ch = str.toCharArray();
        if(isConsonant(ch[0])&&isVowel(ch[1])&&isConsonantExceptr(ch[2])&&ch[3]=='e'){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isConsonant(char c){
        if((c>='a'&&c<='z')&&c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isConsonantExceptr(char c){
        if((c>='a'&&c<='z')&&c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'&&c!='r'){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }else{
            return false;
        }
    }
}