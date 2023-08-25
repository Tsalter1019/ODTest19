package leetcode;

//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
//目来描述。
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
// 示例 1：
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 示例 2：
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 提示：
// 1 <= nums1.length <= 10⁵
// nums2.length == nums1.length
// 0 <= nums1[i], nums2[i] <= 10⁹

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class B870 {
    public static void main(String[] args) {
    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        for(int i=0;i<nums1.length;i++){
            list1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            for(int j=i;j<nums1.length;j++){
                list.add(getMinValue(list1,nums2[i]));
                list1.remove(getIndex(list1,getMinValue(list1,nums2[i])));
                break;
            }
        }
        int[] returnArr = new int[list.size()];
        for(int i=0;i<returnArr.length;i++){
            returnArr[i] = list.get(i);
        }
        return returnArr;
    }
    public static int getIndex(List<Integer> list1,int num){
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)==num){
                return i;
            }
        }
        return 0;
    }
    public static int getMinValue(List<Integer> list,int num){
        Collections.sort(list);
        if(list.get(list.size()-1)<num){
            return list.get(0);
        }else{
            for(int i=0;i<list.size();i++){
                if(list.get(i)>num){
                    return list.get(i);
                }
            }
        }
        return list.get(0);
    }
}