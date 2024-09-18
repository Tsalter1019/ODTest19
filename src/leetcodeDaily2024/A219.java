package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A219 {
    public static void main(String[] args) {
        int [] arr = {1,0,1,1};
        int k =1;
        System.out.println(new A219().containsNearbyDuplicate(arr,k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=k){
                list.add(nums[i]);
            }
        }
        int i=0,j=i+1;
        int l = nums.length;
        while(i<l){
            while(j<l){
                if(i!=j && nums[i]==nums[j] && Math.abs(i-j) <= k){
                    return true;
                }else{
                    j++;
                }
            }
            i++;
            j=i+1;
        }
        return false;
    }
}
