package com.algorithm.DP.dpEvolution;
//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
// 示例 1:
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 示例 2:
//输入: rowIndex = 0
//输出: [1]
// 示例 3:
//输入: rowIndex = 1
//输出: [1,1]
// 提示:
// 0 <= rowIndex <= 33
// 进阶：
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
// Related Topics 数组 动态规划 👍 522 👎 0


import java.util.ArrayList;
import java.util.List;

public class E119 {
    public static void main(String[] args) {
        new E119().getRow(3);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<rowIndex;i++){
            List<Integer> list = new ArrayList<>();
            int row =i+2;
            for(int j=0;j<row;j++){
                if(j == 0 || j == row-1){
                    list.add(1);
                }else{
                    List<Integer> pre = res.get(i-1);
                    int num = pre.get(j) + pre.get(j-1);
                    list.add(num);
                }
            }
            res.add(list);
        }
        int s = res.size();
        if(s>0){
            rr = res.get(s-1);
        }else{
            rr.add(1);
        }

        return rr;
    }
}


