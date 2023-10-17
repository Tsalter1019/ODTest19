package com.basicKnowledge.Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 输入：[2,3,6,7]
 * 输出：[[2,2,3],[7]]  explain：2+2+3=7、7=7
 *//*
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listReturn = new ArrayList<>();//用于返回数据的结果集
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<candidates.length;i++){
            list.add(candidates[i]);
        }
        int idx = list.size();

        dfs(candidates,target,listReturn,list,idx);

        return listReturn;
    }

    public static void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> combine,int idx) {
        if (idx == candidates.length) {
            return ;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
        }
        dfs(candidates,target,ans,combine,idx+1);
        if(target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates,target - candidates[idx],ans,combine,idx);
            combine.remove(combine.size() -1);
        }
    }

//
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int t = 7;

        System.out.println(combinationSum(arr,t));
    }
}*/



public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, i, len, target - candidates[i], path, res);

            path.removeLast();
            System.out.println("递归之后 => " + path);

        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }
}
