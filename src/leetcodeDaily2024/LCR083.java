package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCR083 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new LCR083().permute(arr));
    }
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        process(nums,new LinkedList<>(),used);
        return res;
    }
    public void process (int[] nums, LinkedList<Integer> temp, boolean[] used){
        if(temp.size()==nums.length){
            res.add(new LinkedList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                temp.add(nums[i]);
                used[i] = true;
                process(nums,temp,used);
                temp.removeLast();
                used[i] = false;
            }
        }
    }
}
