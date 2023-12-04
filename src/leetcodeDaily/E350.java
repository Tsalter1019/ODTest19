package leetcodeDaily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E350 {
    public static void main(String[] args) {
        //int[] nums1 = {1,2,2,1};
        int[] nums1 = {4,9,5};//4,5,9
        //int[] nums2 = {2};
        int[] nums2 = {9,4,9,8,4};//4,4,8,9,9

        System.out.println(new E350().intersection(nums1,nums2));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length,n = nums2.length;
        int[] res = new int[Math.min(m,n)];
        int i=0,j=0,index = 0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                res[index] = nums1[i];
                i++;
                j++;
                index++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}