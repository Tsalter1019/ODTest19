package Deke;

import java.util.LinkedList;
import java.util.List;

/**
   所谓的水仙花数是指一个n位的正整数其各位数字的n次方的和等于该数本身，
   例如153=1^3+5^3+3^3,153是一个三位数
   输入描述
       第一行输入一个整数N，
       表示N位的正整数N在3-7之间包含3,7
       第二行输入一个正整数M，
       表示需要返回第M个水仙花数
   输出描述
       返回长度是N的第M个水仙花数，
       个数从0开始编号，
       若M大于水仙花数的个数返回最后一个水仙花数和M的乘积，
       若输入不合法返回-1

   示例一：

       输入
        3
        0
       输出
        153
       说明：153是第一个水仙花数
    示例二：
       输入
       9
       1
       输出
       -1
    */
public class A70 {
    public static void main(String[] args) {
        //System.out.println(isDaffodils(154));
        System.out.println(solution(4,0));
    }
    public static int solution(int N,int M){
        List<Integer> list =  new LinkedList<>();
        if(N>7||N<3){
            return -1;
        }
        for(int i=0;i<Math.pow(10,N);i++){
            if(isDaffodils(i)&&(i+"").length()==N){
                list.add(i);
            }
        }

        if(M<=list.size()){
            return list.get(M);
        }else{
            return list.get(list.size()-1)*M;
        }


    }
    public static boolean isDaffodils(int num){
        char[] arr = (num+"").toCharArray();
        int[] nums = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i] = Integer.parseInt(arr[i]+"");
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.pow(nums[i],nums.length);
        }
        if(num==sum){
            return true;
        }else{
            return false;
        }
    }
}