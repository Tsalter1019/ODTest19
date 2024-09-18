package leetcodeDaily2024;

import java.util.HashMap;
import java.util.Map;

public class A1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int rest = target - nums[i];
            if(map.containsKey(rest)){
                res[0] = i;
                res[1] = map.get(rest);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
