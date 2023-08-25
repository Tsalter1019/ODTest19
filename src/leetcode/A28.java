package leetcode;

/**
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * aaa aaaa  -1
 * aaa a 0
 * "mississippi"
 * "issip"
 */
public class A28 {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));
    }
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

}