package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找两个正序数组的中位数
 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2


  示例 2：


 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class C4 {
    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2};
        System.out.println(new C4().findMedianSortedArrays(a,b));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        if(list.size()%2==0){
            return (double)(list.get(list.size()/2-1) + list.get(list.size()/2))/2;
        }else{
            return (double)(list.get(list.size()/2));
        }
    }

}