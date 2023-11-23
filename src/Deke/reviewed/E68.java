package Deke.reviewed;

import java.util.LinkedList;

/**
给定一个随机的整数数组(可能存在正整数和负整数)nums,
请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
并返回这两个数(按从小到大返回)以及绝对值。
每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

输入描述：
 一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
 且整数数值范围是[-65535,65535]

输出描述：
  两个数和两数之和绝对值

 示例一：
  输入
  -1 -3 7 5 11 15
  输出
  -3 5 2

说明：
因为|nums[0]+nums[2]|=|-3+5|=2最小，
所以返回-3 5 2

 */
public class E68 {
    public static void main(String[] args) {
        int[] arr = {-1,-3,7,5,11,15};
        int[] nums = solution(arr);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static int[] solution(int[] arr){
        int[] result = new int[3];
        int index0=0;
        int index1=0;
        int min=absoluteValueSum(arr[0],arr[1]);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(absoluteValueSum(arr[i],arr[j]) < min){
                    min = absoluteValueSum(arr[i],arr[j]);
                    index0 = i;
                    index1 = j;
                }
            }
        }
        result[0] = arr[index0];
        result[1] = arr[index1];
        result[2] = absoluteValueSum(arr[index0],arr[index1]);
        return result;
    }

    //返回和的绝对值
    public static int absoluteValueSum(int num1,int num2){
        int a = num1+num2;
        if(a>=0){
            return a;
        }else{
            return -a;
        }
    }
}