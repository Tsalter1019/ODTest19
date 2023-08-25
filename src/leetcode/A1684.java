package leetcode;

//给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字
//符串 。
// 请你返回 words 数组中 一致字符串 的数目。
//输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//输出：2
//解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
//输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
//输出：7
//解释：所有字符串都是一致的。
//输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
//输出：4
//解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。


import java.util.*;

public class A1684 {
    public static void main(String[] args) {
        String allowed="ab";
        String[] words={"ad","bd","aaab","baa","badab"};
        System.out.println(new A1684().countConsistentStrings(allowed,words));
    }
    public int countConsistentStrings(String allowed, String[] words) {

        int count=0;
        /*char[] ch1 = allowed.toCharArray();
        List<Character> list1 = new ArrayList<>();
        for(char cc:ch1){
            list1.add(cc);
        }
        Collections.sort(list1);
        String ss="";
        for(int k=0;k<list1.size();k++){
            ss+=list1.get(k);
        }*/

        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            Set<Character> set = new HashSet<>();
            for(char m:ch){
                set.add(m);
            }
            int temp=0;
            List<Character> list = new ArrayList<>(set);
            for(int w=0;w<list.size();w++){
                if(allowed.contains(list.get(w)+"")){
                    temp++;
                }
            }
            if(temp==list.size()){
                count++;
            }
            temp=0;

        }
        return count;
    }
}