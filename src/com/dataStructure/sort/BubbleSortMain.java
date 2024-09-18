package com.dataStructure.sort;

/**
 * 冒泡排序
 */

public class BubbleSortMain {
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,6,8};
        System.out.println(bubblesort(arr));

    }

    public static int[] bubblesort(int [] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }


}