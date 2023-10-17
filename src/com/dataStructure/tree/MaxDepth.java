package com.dataStructure.tree;


public class MaxDepth {
    //深度优先
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int leftHight = maxDepth(root.left);
            int rightHight = maxDepth(root.right);
            return Math.max(leftHight,rightHight) + 1;
        }
    }
}