package leetcodeDaily;


import java.util.ArrayList;
import java.util.List;

public class A35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int t = 7;
        System.out.println(new A35().searchInsert(nums,t));
    }
    public int searchInsert(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        for(int i=0;i<list.size();i++){
            if(nums[i]==target){
                return i;
            }
        }
        if(!list.contains(target)){
            for(int i=0;i<list.size();i++){
                if(target<list.get(i)){
                    return i;
                }
            }
        }
        if(list.get(list.size()-1)<target){
            return list.size()-1;
        }
        return 0;
    }
}