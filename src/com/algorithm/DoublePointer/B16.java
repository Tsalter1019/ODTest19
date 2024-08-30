package com.algorithm.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=0;
        int min=Integer.MAX_VALUE;//sum-target  abs最小视为最接近
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int m=j+1;m<nums.length;m++){
                    if(Math.abs(nums[i]+nums[j]+nums[m]-target)<min){
                        sum = nums[i]+nums[j]+nums[m];
                        min = Math.abs(nums[i]+nums[j]+nums[m]-target);
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] arr = {-1,2,1,-4};
        int[] arr = {0,0,0};
        System.out.println(new B16().threeSumClosest(arr,1));
    }
}
