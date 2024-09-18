package com.dataStructure.sort;

public class Quicksort2024 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,6,2};
        quicksort(arr,0,arr.length-1);
        System.out.println(arr);
    }
    public static void quicksort(int[] arr,int p,int r){
        if(p<r){
            int q = partition(arr,p,r);
            quicksort(arr,p,q-1);
            quicksort(arr,q+1,r);
        }
    }

    public static int partition(int[] arr,int p,int r){
        int x = arr[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<=x){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i+1;
    }

}
