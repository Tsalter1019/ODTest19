package com.dataStructure.tree;


/**
 * DFS Depth First Search
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 *
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 输入：root = [0]
 * 输出：0

 */

public class SumRootLeaf {
    public int sumRootToLeaf(TreeNode root){
        return dfs(root,0);
    }

    //使用深度优先算法计算
    private int dfs(TreeNode root,int road) {
        if(null == root)
            return 0;
        road = (road << 1) + root.val;
        if(null == root.left && null == root.right){
            return road;
        }
        int left = dfs(root.left,road);
        int right = dfs(root.right,road);
        return left+right;
    }
}







