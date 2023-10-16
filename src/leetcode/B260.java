package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B260 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(new B260().singleNumber(nums));
    }
    public int[] singleNumber(int[] nums) {
        List list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.keySet().contains(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int count=0;
        for(int i :map.keySet()){
            if(map.get(i)==1){
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = (int) list.get(i);
        }
        return arr;
    }
}