package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//全排列
public class B46 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(new B46().permute(a));

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int [] b = new int[nums.length];
        boolean [] isUse = new boolean[nums.length];
        int n = nums.length;
        int flag=0;
        for(int i:nums){
            list.add(i);
        }
        dfs(n,list,lists,0);
        return lists;
    }
    void dfs(int n,List<Integer> list,List<List<Integer>> lists,int flag){

        if(flag==n){
            lists.add(new ArrayList<Integer>(list));
        }else{
            for(int i=flag;i<list.size();i++){
                Collections.swap(list,flag,i);
                dfs(n, list, lists, flag+1);
                Collections.swap(list,flag,i);
            }
        }
    }

}
