package com.dataStructure.sort;


import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        //时间复杂度  O(nlogn)
        //空间复杂度  O(nlogn)
        //大顶堆  arr[i] >= arr[2i+1]  &&  arr[i] >= arr[2i+2]      一般升序采用
        //小顶堆  arr[i] <= arr[2i+1]  &&  arr[i] <= arr[2i+2]      一般降序采用
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //使用堆排序，将数组升序排序
        for(int i=arr.length/2 - 1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        int temp=0;
        for(int j=arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    public static void adjustHeap(int[] arr,int i,int length){
        //将数组排序从{4,6,8,5,9} 调整为 {4,9,8,5,6} 即构建大顶堆的过程
        int temp = arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            //左子树和右子树的数据进行比较,更换较大的数据
            if(k+1<length && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                //swap
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
}