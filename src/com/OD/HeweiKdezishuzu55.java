package com.OD;

import java.util.Scanner;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你统计并返回该数组中和为 k 的连续子数组的个数。
 */

public class HeweiKdezishuzu55 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;++i){
            int sum = 0;
            for(int j = i;j>=0;--j){
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] str =s.split(",");
        int [] numA = new int[str.length];
        for(int i=0;i<str.length;i++){
            numA[i] = Integer.parseInt(str[i]);
        }
        System.out.println(subarraySum(numA,2));
    }
}