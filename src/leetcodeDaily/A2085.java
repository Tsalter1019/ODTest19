package leetcodeDaily;

//给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
// 示例 1：
//输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing",
//"leetcode","is"]
//输出：2
//解释：
//- "leetcode" 在两个数组中都恰好出现一次，计入答案。
//- "amazing" 在两个数组中都恰好出现一次，计入答案。
//- "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
//- "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
//所以，有 2 个字符串在两个数组中都恰好出现了一次。
// 示例 2：
//输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
//输出：0
//解释：没有字符串在两个数组中都恰好出现一次。
// 示例 3：
//输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
//输出：1
//解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
// 提示：
// 1 <= words1.length, words2.length <= 1000
// 1 <= words1[i].length, words2[j].length <= 30
// words1[i] 和 words2[j] 都只包含小写英文字母。
// Related Topics 数组 哈希表 字符串 计数 👍 19 👎 0


import java.util.HashMap;
import java.util.Map;

public class A2085 {
    public static void main(String[] args) {
        String [] words1 = {"leetcode","is","amazing","as","is"};
        String [] words2 = {"amazing", "leetcode","is"};
        System.out.println(new A2085().countWords(words1,words2));
    }
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map1 = new HashMap<>();
        for(int i=0;i<words1.length;i++){
            if(!map.keySet().contains(words1[i])){
                map.put(words1[i],1);
            }else{
                map.put(words1[i],map.get(words1[i])+1);
            }
        }
        for(int i=0;i<words2.length;i++){
            if(!map1.keySet().contains(words2[i])){
                map1.put(words2[i],1);
            }else{
                map1.put(words2[i],map1.get(words2[i])+1);
            }
        }
        int count=0;
        for(String str : map.keySet()){
            for(String str1 : map1.keySet()){
                if(str.equals(str1) && map.get(str)==1 && map1.get(str1)==1){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}