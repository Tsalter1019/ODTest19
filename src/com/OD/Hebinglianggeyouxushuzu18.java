package com.OD;


import java.util.Arrays;

public class Hebinglianggeyouxushuzu18 {
    public void merge(int[] nums1,int m,int[] nums2,int n){
        for(int i=0;i!=n;++i){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {

    }
}