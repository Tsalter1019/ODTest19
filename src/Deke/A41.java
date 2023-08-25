package Deke;

import java.util.Arrays;

/** 给定参数n 从1到n会有n个整数 1，2，3，...n   这n个数字共有n!种排列 按大小顺序升序列出所有排列情况 并一一标记 当n=3时，所有排列如下
    "123","132","213","231","312","321" 给定n和k 返回第n个排列
    输入描述
    第一行为n 第二行为k  n的范围是 1~9 k的范围是 1~n!
    输出描述
    输出排列第k位置的数字
    示例一：
    输入
    3
    3
    输出
    213
    示例二:
    输入
    2
    2
    输出
    21
     */
public class A41 {

    public static void main(String[] args) {
        System.out.println(new A41().getPermutation1(3,3));
    }

    /**
     * 记录数字是否使用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

        // 查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }


    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param path
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     *
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public String getPermutation1(int n, int k) {
        StringBuilder ret = new StringBuilder();
        int[] factorial = new int[n];   // 0 ~ (n-1) 对应的阶乘
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
        boolean[] selected = new boolean[n+1];
        while (ret.length() < n) {
            // 当前应当选择第几大的数
            int p = (k - 1) / factorial[n-1-ret.length()] + 1;
            k = k - (p -1) * factorial[n-1-ret.length()];
            int count = 0;
            for (int i=1; i<selected.length; i++) {
                if (selected[i])
                    continue;
                count++;
                if (count == p) {
                    ret.append(i);
                    selected[i] = true;
                    break;
                }
            }
        }
        return ret.toString();
    }

}