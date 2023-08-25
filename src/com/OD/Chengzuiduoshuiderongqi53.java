package com.OD;
/**
 * 盛最多水的容器
 */

import java.util.Scanner;

public class Chengzuiduoshuiderongqi53 {
    public int maxArea(int [] height){
        //int l = 0, r = height.length-1;
        //int ans = 0;
        //while(l < r) {
        //    int area = Math.min(height[l], height[r]) * (r - l);
        //    ans = Math.max(ans, area);
        //    if (height[l] <= height[r]) {
        //        ++l;
        //    }
        //    else {
        //        --r;
        //    }
        //}
        //return ans;

        int l = 0, r = height.length - 1;
        int ans = 0;
            while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {  // 移动较小的那一端
            ++l;
            }
            else {
            --r;
            }
            }
            return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

    }
}


