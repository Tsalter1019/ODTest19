package com.Array;


import java.util.Arrays;
import java.util.Scanner;

public class Makesquare {

    public static boolean dfs(int index,int[] ma,int[] edges,int len){
        //if(index==ma.length){
        //    return true;
        //}
        for(int i=0;i<edges.length;i++){
            edges[i]+=ma[index];
            if(edges[i]<=len&&dfs(index+1,ma,edges,len)){
                return true;
            }
            edges[i]-=ma[index];
        }
        return false;
    }

    public static boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int sum = 0;
        for(int i = 0; i < matchsticks.length; i++){
            sum += matchsticks[i];
        }
        //降序排序
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] e = new int[4];
        return dfs(0,matchsticks,e,sum/4);

    }

    public static void main(String[] args) {
        int[] a={5,5,5,5,4,4,4,4,3,3,3,3};
        int[] b={1,1,2,2,2};
        System.out.println(makesquare(a));
    }
}