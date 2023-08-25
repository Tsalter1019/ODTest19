package com.DP;

/***************最长公共子序列变种******************
 *
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。 设KK位同学从左到右依次编号为 1，2…，K ，
 * 他们的身高分别为T1,T2,…,TKT ，若存在i(1≤i≤K) 使得T1<T2<......<T{i-1}<Ti且 Ti>T{i+1}>......>TK，则称这KK名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * 8
 * 186 186 150 200 160 130 197 200
 * 4
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */

import java.util.Arrays;

public class Choir {
    public static void main(String[] args) {
        int m = 8;
        int[] arr = {186,186,150,200,160,130,197,200};
        System.out.println(solution(m,arr));
    }
    public static int solution(int m,int[] arr){

        int[] result = new int[m];

        int[] left = new int[m];//存放从左往右递增的可以组成排列的个数
        int[] right = new int[m];//存放从右往左递增的可以组成排列的个数
        left[0] = 1;
        right[m-1] = 1;
        //从左往右
        for(int i=0;i<m;i++){
            left[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    left[i] = Math.max(left[i],left[j]+1);
                }
            }
        }

        //从右往左日常的算法练习Daily algorithm exercise
        for(int i=m-1;i>=0;i--){
            right[i] = 1;
            for(int j=m-1;j>i;j--){
                if(arr[i]>arr[j]){
                    right[i] = Math.max(right[i],right[j]+1);
                }
            }
        }

        for(int i=0;i<m;i++){
            result[i] = left[i] + right[i]-1;
        }

        Arrays.sort(result);

        return m - result[result.length-1];
    }
}