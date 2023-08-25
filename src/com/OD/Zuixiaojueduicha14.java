package com.OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对差
 */

public class Zuixiaojueduicha14 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int temp = Integer.MAX_VALUE;
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(i+1<arr.length){
                j=temp;
                if(Math.min(temp,arr[i+1]-arr[i])==arr[i+1]-arr[i]){
                    temp = arr[i+1] - arr[i];
                    if(j!=temp){
                        lists.clear();
                    }
                    list.add(arr[i]);
                    list.add(arr[i+1]);
                    lists.add(new ArrayList<>(list));
                    list.clear();
                }else{
                    continue;
                }
            }
        }
        return lists;
    }

}