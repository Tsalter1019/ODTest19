package leetcodeDaily;

//给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母
//。如果不存在这样的两个单词，返回 0 。
// 示例 1：
//输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出：16
//解释：这两个单词为 "abcw", "xtfn"。
// 示例 2：
//输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出：4
//解释：这两个单词为 "ab", "cd"。
// 示例 3：
//输入：words = ["a","aa","aaa","aaaa"]
//输出：0
//解释：不存在这样的两个单词。
public class B318 {
    public static void main(String[] args) {
        String[] str = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new B318().maxProduct(str));
    }
    public int maxProduct(String[] words) {
        int max=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(!isContainCommonLetter(words[i],words[j])){
                    int mul = words[i].length()*words[j].length();
                    if(max<mul){
                        max = mul;
                    }
                }
            }
        }
        return max;
    }
    public static boolean isContainCommonLetter(String str1,String str2){
        int count=0;
        for(int i=0;i<str2.length();i++){
            if(str1.contains(str2.charAt(i)+"")){
                count++;
            }
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
}