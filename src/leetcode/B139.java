package leetcode;

import java.util.LinkedList;
import java.util.List;

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
            for(int i=0;i<wordDict.size();i++){
                if(s.contains(wordDict.get(i))){
                    s = quchu(s,wordDict.get(i));
                    if(s.length()==0){
                        return true;
                    }else{
                        return wordBreak(s,wordDict);
                    }
                }
            }
        return false;
    }

    public static String quchu(String a,String b){//String      a.indexOf(b)  如果字符串a包含b  则返回b在a中的第一个索引位置
        StringBuilder stringBuilder = new StringBuilder();
        if(a.indexOf(b)!=-1){
            stringBuilder.append(a.substring(0,a.indexOf(b)));
            stringBuilder.append(a.substring(a.indexOf(b)+b.length(),a.length()));
        }
        return stringBuilder.toString();
    }
}