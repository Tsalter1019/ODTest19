package leetcode;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
public class B179 {
    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};
        //System.out.println(compare(92,93));
        System.out.println(solution(nums));
    }
    public static String solution(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(compare(nums[j],nums[i])){
                    int temp = 0;
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i]  = temp;
                    break;
                }
            }
        }
        return "ss";
    }
    public static boolean compare(int a,int b){
        char[] aa = (a+"").toCharArray();
        char[] bb = (b+"").toCharArray();
        int index=0;
        for(int i=index;i<aa.length;i++){
            for(int j=index;j<bb.length;j++){
                if(Integer.parseInt(aa[i]+"")>Integer.parseInt(bb[j]+"")){
                    return true;
                }else if(Integer.parseInt(aa[i]+"")==Integer.parseInt(bb[j]+"")){
                    index++;
                    break;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}