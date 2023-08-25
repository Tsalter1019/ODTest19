package com.Array;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入：[2,3,6,7]
 * 输出：[[2,2,3],[7]]  explain：2+2+3=7、7=7
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listReturn = new ArrayList<>();//用于返回数据的结果集
        List<Integer> list = new ArrayList<>();
        //2*a+3*b+6*c+7*d==target

        return null;
    }

    public void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> combine,int idx) {
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

    }
}