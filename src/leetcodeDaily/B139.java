package leetcodeDaily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。  注意，你可以重复使用字典中的单词。
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class B139 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        String s = "applepenappleapplepen";
        list.add("apple");
        list.add("pen");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wordBreak(s,list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String  temp = s.substring(j,i);
                if(dp[j] && words.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}