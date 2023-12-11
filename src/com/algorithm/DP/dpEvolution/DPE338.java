package com.algorithm.DP.dpEvolution;

//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
// 示例 1：
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 示例 2：
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 提示：
// 0 <= n <= 10⁵
// 进阶：
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
// Related Topics 位运算 动态规划 👍 1283 👎 0
public class DPE338 {
    public static void main(String[] args) {
        //System.out.println(new DP338().count1(0));
        //System.out.println(new DP338().count1(1));
        //System.out.println(new DP338().count1(2));
        //System.out.println(new DP338().count1(3));
        //System.out.println(new DP338().count1(4));
        //System.out.println(new DP338().count1(5));
        System.out.println(new DPE338().countBits(5));
    }
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = count1(i);
        }
        return arr;
    }
    public int[] countBits1(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++){

        }
        return arr;
    }
    public static int count1(int n){
        int count=0;
        while(n>0){
            if(n%2==1){
                count++;
            }
            n/=2;
        }
        return count;
    }
    public static int count(int n){
        int count=0;
        char[] ch = (n+"").toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'){
                count++;
            }
        }
        return count;
    }
}