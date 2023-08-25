package com.temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用数组代表每个人的能力
 * 一个活动比赛要求参赛团队的最低能力值为N，每个团队可以由一人或者两个人组成
 * 且一个人只能参加一个团队
 * 计算出最多可以派出复合要求的队伍
 *
 * 输入
 * 5                     总人数
 * 3 1 5 7 9             每个人的能力
 * 8                     团队要求的最低能力值
 *
 * 输出
 * n
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        int base = Integer.parseInt(sc.nextLine());

        Integer[] list = Arrays.stream(nums)
                .map(Integer::parseInt)
                .filter(x -> x<base)
                .sorted()
                .toArray(Integer[]::new);
        int count = nums.length - list.length;

        int i=0,j=list.length-1;
        while(i<j){
            if(list[i]+list[j]>=base){
                count++;
                i++;
                j--;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}