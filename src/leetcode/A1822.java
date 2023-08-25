package leetcode;

//已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
// 如果 x 是正数，返回 1 。
// 如果 x 是负数，返回 -1 。
// 如果 x 是等于 0 ，返回 0 。
// 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
// 返回 signFunc(product) 。
// 示例 1：
//输入：nums = [-1,-2,-3,-4,3,2,1]
//输出：1
//解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
// 示例 2：
//输入：nums = [1,5,0,2,-3]
//输出：0
//解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
// 示例 3：
//输入：nums = [-1,1,-1,1,-1]
//输出：-1
//解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1

public class A1822 {
    public static void main(String[] args) {
        int[] nums = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        System.out.println(new A1822().arraySign(nums));
    }
    public int arraySign(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                arr[i]=1;
            }else if(nums[i]==0){
                arr[i]=0;
            }else{
                arr[i]=-1;
            }
        }
        int sum=1;
        for(int i=0;i<arr.length;i++){
            sum*=arr[i];
        }
        return sum;
    }
}