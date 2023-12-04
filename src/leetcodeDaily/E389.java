package leetcodeDaily;

//给定两个字符串 s 和 t ，它们只包含小写字母。
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
// 请找出在 t 中被添加的字母。
// 示例 1：
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 示例 2：
//输入：s = "", t = "y"
//输出："y"
// 提示：
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
// Related Topics 位运算 哈希表 字符串 排序 👍 434 👎 0

import java.util.Arrays;

public class E389 {
    public static void main(String[] args) {
        //String s = "abcd";
        //String t = "abcde";
        String s = "";
        String t = "y";
        System.out.println(new E389().findTheDifference(s,t));
    }
    public char findTheDifference(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(ch1.length>ch2.length){
            for(int i=0;i<ch2.length;i++){
                for(int j=i;j<ch2.length;j++){
                    if(ch1[i]==ch2[j]){
                        break;
                    }else{
                        return ch1[i];
                    }
                }
            }
            return ch1[ch1.length-1];
        }else if(ch1.length<ch2.length){
            for(int i=0;i<ch1.length;i++){
                for(int j=i;j<ch1.length;j++){
                    if(ch1[i]==ch2[j]){
                        break;
                    }else{
                        return ch2[i];
                    }
                }
            }
            return ch2[ch2.length-1];
        }
        return 'a';
    }
}