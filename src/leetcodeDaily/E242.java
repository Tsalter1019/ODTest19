package leetcodeDaily;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
// 示例 1:
//输入: s = "anagram", t = "nagaram"
//输出: true
// 示例 2:
//输入: s = "rat", t = "car"
//输出: false
// 提示:
// 1 <= s.length, t.length <= 5 * 10⁴
// s 和 t 仅包含小写字母
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 哈希表 字符串 排序 👍 869 👎 0

import java.util.Arrays;

public class E242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new E242().isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        char[] aa = s.toCharArray();
        char[] bb = t.toCharArray();
        String aaa = "";
        String bbb = "";
        Arrays.sort(aa);
        Arrays.sort(bb);
        for(int i=0;i<aa.length;i++){
            aaa+=aa[i];
        }
        for(int i=0;i<bb.length;i++){
            bbb+=bb[i];
        }
        if(aaa.equals(bbb)){
            return true;
        }else{
            return false;
        }
    }
}