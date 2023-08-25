package com.OD;

/**
 * 接雨水
 */

import java.util.Scanner;

public class Jieyushui {
    public static int solution(int [] height){

        int n = height.length;
        if(n==0) return 0;

        int [] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i=1;i<n;++i){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        int [] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;--i){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] sA = str.split(",");
        int [] nA = new int[sA.length];
        for(int i=0;i<sA.length;i++){
            nA[i] = Integer.parseInt(sA[i]);
        }
        System.out.println(solution(nA));
        sc.close();
    }
}