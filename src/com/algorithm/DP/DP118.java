package com.algorithm.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角1
 */
public class DP118 {
    public static void main(String[] args) {
        System.out.println(new DP118().generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
                int row = i+1;
            for(int j=0;j<row;j++){
                if(j==0 || j==row-1){
                    list.add(1);
                }else{
                    List<Integer> pre = res.get(i-1);
                    int num = pre.get(j) + pre.get(j-1);
                    list.add(num);
                }
            }
            res.add(list);
        }
        return res;
    }
}