package leetcodeDaily;

//一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
// 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
// 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
// 示例 1：
//输入：s = "leeetcode"
//输出："leetcode"
//解释：
//从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
//没有连续三个相同字符，所以返回 "leetcode" 。
// 示例 2：
//输入：s = "aaabaaaa"
//输出："aabaa"
//解释：
//从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
//从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
//没有连续三个相同字符，所以返回 "aabaa" 。
// 示例 3：
//输入：s = "aab"
//输出："aab"
//解释：没有连续三个相同字符，所以返回 "aab" 。
// 1 <= s.length <= 10⁵
// s 只包含小写英文字母。


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class A1957 {
    public static void main(String[] args) {
        System.out.println(new A1957().makeFancyString("aabaaaa"));
    }
    public String makeFancyString(String s) {
        char[] ch = s.toCharArray();
        int count=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<ch.length-1;i++){
            for(int j=i+1;j<ch.length;j++){
                stack.push(ch[i]);
                if(ch[i]==ch[j]){
                    count++;
                }
                break;
            }
            if(count==2){
                stack.pop();
                count=0;
            }

        }

        /*for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)!=s.charAt(j)){
                    stringBuffer.append(s.charAt(i));
                    break;
                }else{
                    count++;
                }
            }
        }*/

        List<Character> list = new LinkedList<>(stack);
        String re="";
        for(char i:list){
            re+=i;
        }






        return re;
    }


}