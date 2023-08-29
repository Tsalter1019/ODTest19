package com.leetcode.dailytest;


/**
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0开始的字符串s，它只包含字符'*' 和'|'，其中'*'表示一个 盘子，'|'表示一支蜡烛。
 *
 * 同时给你一个下标从 0开始的二维整数数组queries，其中queries[i] = [lefti, righti]表示 子字符串s[lefti...righti]（包含左右端点的字符）。
 * 对于每个查询，你需要找到 子字符串中在 两支蜡烛之间的盘子的 数目。如果一个盘子在 子字符串中左边和右边 都至少有一支蜡烛，那么这个盘子满足在
 * 两支蜡烛之间。
 * 比方说，s = "||**||**|*"，查询[3, 8]，表示的是子字符串"*||**|"。子字符串中在两支蜡烛之间的盘子数目为2，子字符串中右边两个盘子在它们左边
 * 和右边 都 至少有一支蜡烛。请你返回一个整数数组answer，其中answer[i]是第i个查询的答案。
 *
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 *
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 *
 */

public class PlatesBetweenCandles {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int n = s.length();
            int[] preSum = new int[n];
            for (int i = 0, sum = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    sum++;
                }
                preSum[i] = sum;
            }
            int[] left = new int[n];
            for (int i = 0, l = -1; i < n; i++) {
                if (s.charAt(i) == '|') {
                    l = i;
                }
                left[i] = l;
            }
            int[] right = new int[n];
            for (int i = n - 1, r = -1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    r = i;
                }
                right[i] = r;
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int x = right[query[0]], y = left[query[1]];
                ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
            }
            return ans;
        }

}