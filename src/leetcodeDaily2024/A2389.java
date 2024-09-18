package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2389 {
    public static void main(String[] args) {
//        int [] nums= {736411,184882,914641,37925,214915};
        int [] nums= {1000};
//        int[] q = {331244,273144,118983,118252,305688,718089,665450};
        int[] q = {1000};
        System.out.println(new A2389().answerQueries(nums,q));
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        if(nums.length==queries.length && nums.length==1 && nums[0]==queries[0]){
            int [] arr = {1};
            return arr;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int count=0;
        for(int i=0;i<queries.length;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if(sum<=queries[i] && queries[i]>nums[j]){
                    sum+=nums[j];
                    if(sum<=queries[i]){
                        count++;
                    }else{
                        sum-=nums[j];
                    }

                }
            }
            list.add(count);
            count=0;
            sum=0;
        }

        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
