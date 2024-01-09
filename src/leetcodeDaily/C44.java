package leetcodeDaily;

//给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
//
//
// '?' 可以匹配任何单个字符。
// '*' 可以匹配任意字符序列（包括空字符序列）。
//
//
//
//
// 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
//
//
//
//
// 示例 1：
//
//
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2：
//
//
//输入：s = "aa", p = "*"
//输出：true
//解释：'*' 可以匹配任意字符串。
//
//
// 示例 3：
//
//
//输入：s = "cb", p = "?a"
//输出：false
//解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//
//
//通配符
//
// 提示：
//
//
// 0 <= s.length, p.length <= 2000
// s 仅由小写英文字母组成
// p 仅由小写英文字母、'?' 或 '*' 组成
//
// Related Topics 贪心 递归 字符串 动态规划 👍 1115 👎 0

import java.util.Scanner;

public class C44 {
    public static void main(String[] args) {
        //String p1 = "p*p*qp**pq*p**p***ppq";
        //String p2 = "?*bc*?";
        //String p3 = "te?t*.*";
        //String s1 = "pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp";
        //String s2 = "abcd";
        //String s3 = "txt12.xls";
        //System.out.println(new C44().isMatch(s1,p1));
        //System.out.println(new C44().isMatch(s2,p2));
        //System.out.println(new C44().isMatch(s3,p3));
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String pp = in.nextLine();
            String ss = in.nextLine();
            String p = pp.toLowerCase();
            String s = ss.toLowerCase();
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

