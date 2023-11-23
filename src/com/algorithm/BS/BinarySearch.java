package com.algorithm.BS;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = suiji();

        Arrays.sort(array);
        System.out.println("产生的随机数组为：" + Arrays.toString(array));

        System.out.println("要进行查找的值为： ");
        Scanner input= new Scanner(System.in);

        //进行目标查找
        int aim = input.nextInt();

        //二分查找
        int index = binarySearch(array,aim);
        int index2 = binarySearch2(array,aim,0,array.length-1);

        System.out.println("查找的索引位置是：" + index);
        System.out.println("查找的索引位置是：" + index2);
    }

    /**
     * 生成一个随机数组
     * @return 返回值 ，返回一个随机数组
     */
    private static int[] suiji(){
        // random.nextInt(n)+m   返回m到m+n-1之间的随机数
        int n = new Random().nextInt(6) + 5;//返回5-10之间的随机数
        int [] array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    /**
     * 二分查找    -- 循环方式实现
     * @param array
     * @param aim
     * @return 返回值，成功返回索引，失败返回-1
     */
    private static int binarySearch(int[] array,int aim) {
        //数组最小索引值
        int left = 0;
        //数组最大索引值
        int right = array.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(aim < array[mid]){
                right = mid - 1;
            }else if(aim > array[mid]){
                left = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分法查找 --递归的方式
     * @param array 要查找的数组
     * @param aim
     * @param left  左边的最小值
     * @param right 右边的最大值
     * @return
     */
    private static int binarySearch2(int[] array,int aim,int left,int right) {
        if(aim < array[left] || aim > array[right]) {
            return -1;
        }
        //找中间值
        int mid = (left + right) / 2;
        if(array[mid] == aim) {
            return mid;
        } else if(array[mid] > aim) {
            return binarySearch2(array,aim,left,mid -1);
        } else {
            return binarySearch2(array,aim,mid+1, array.length-1);
        }
    }
}