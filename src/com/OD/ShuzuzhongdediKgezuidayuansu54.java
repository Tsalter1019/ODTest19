package com.OD;


import java.util.Arrays;
import java.util.Scanner;

public class ShuzuzhongdediKgezuidayuansu54 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //int k=4;
        String[] strA= s.split(",");
        int []  numA = new int[strA.length];
        for(int i = 0;i<strA.length;i++){
            numA[i] = Integer.parseInt(strA[i]);
        }
        System.out.println(findKthLargest(numA,4));
    }
}