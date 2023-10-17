package com.dataStructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序  将A[p..r] 划分为 A[p..q-1]  和 A[q+1,..r]
 *          然后递归调用A[p..q-1]、A[q+1,..r]
 *
 *   QUICKSORT(A,p,r)
 *   if p<r
 *      q=PARTITION(A,p,r)
 *      QUICKSORT(A,p,q-1)
 *      QUICKSORT(A,q+1,r)
 *
 *   PARTITION(A,p,r)
 *   x = A[r]
 *   i = p-1
 *   for j = p to r-1
 *      if A[j]<=x
 *          i=i+1
 *          exchange A[i] with A[j]
 *  exchange A[i+1] with A[r]
 *  return i+1
 */

public class QuickSortMain {

    public static void main(String[] args) {
        int[] a = new int[1000000];
        boolean flag = true;
        //random array
        for (int i = 0; i < a.length; i++) {
            Random rd = new Random();
            a[i] = rd.nextInt(1000000);
        }

        System.out.println("Random Array :");
        System.out.println(Arrays.toString(a));
        System.out.println();
        System.out.println("Quick Sort :");

        //单轴快速排序开始
        //开始时间
        long startTime = System.currentTimeMillis();
        QUICKSORT(a, 0, a.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(a));
        System.out.println("运行时间为： "+(endTime - startTime) + " ms");

    }

    //p-->low  r-->high
    private static int [] QUICKSORT(int [] A,int p,int r){
        if(p<r){
            int q = PARTITION(A,p,r);
            QUICKSORT(A,p,q-1);
            QUICKSORT(A,q+1,r);
        }
        return A;
    }

    private static int PARTITION(int [] A,int p,int r){
        int x = A[r];//r为最后一个数的下标
        int i = p-1;//
        for(int j = p;j<=r-1;j++){
            if(A[j]<=x){
                i = i+1;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
        return i+1;
    }

    private static void swap(int [] A,int m,int n){
        int temp = 0;
        temp = A[m];
        A[m] = A[n];
        A[n] = temp;
    }

}

























