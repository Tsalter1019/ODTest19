package leetcodeDaily;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 *
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 *
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 *
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 *
 * 输入：s = "ab123"
 * 输出："1a2b3"
 */
public class A1417 {

    public static void main(String[] args) {
        String s="a0b1c2";
        System.out.println(reformat(s));
    }

    public static String reformat(String s) {
        List<Character> list = new LinkedList<>();
        List<Character> list1 = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(Character.isDigit(ch[i])){
                list.add(ch[i]);
            }
            if(Character.isLowerCase(ch[i])){
                list1.add(ch[i]);
            }
        }
        if(list.size() == list1.size() + 1){
            for(int i=0;i<list1.size();i++){
                stringBuilder.append(list.get(i));
                stringBuilder.append(list1.get(i));
            }
            stringBuilder.append(list.get(list.size()-1));
            return stringBuilder.toString();
        }else if(list1.size() == list.size() + 1){
            for(int i=0;i<list.size();i++){
                stringBuilder.append(list1.get(i));
                stringBuilder.append(list.get(i));
            }
            stringBuilder.append(list1.get(list1.size()-1));
            return stringBuilder.toString();
        }else if(list.size()==list1.size()){
            for(int i=0;i<list.size();i++){
                stringBuilder.append(list.get(i));
                stringBuilder.append(list1.get(i));
            }
            return stringBuilder.toString();
        }else{
            return "";
        }
    }
}