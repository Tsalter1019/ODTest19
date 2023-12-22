package com.OD1;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 双十一众多商品进行打折销售，小明想购买一些自己心仪的商品，
 * 但由于受购买资金限制，所以他决定从众多心意商品中购买3件，
 * 而且想尽可能的花完资金，
 * 现在请你设计一个程序帮助小明计算尽可能花费的最大资金额。
 *
 * 第一行为整型数组M，数组长度小于100，数组元素记录单个商品的价格；
 * 单个商品价格小于1000；
 * 第二行输入为购买资金的额度R；
 * R < 100000。
 *
 * 输出为满足上述条件的最大花费额度
 * 如果不存在满足上述条件的商品请返回-1
 *
 * 23,26,36,27
 * 78
 *
 * 76
 *
 * 23,30,40
 * 26
 *
 * -1
 */
public class Test0008 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String[] arrays = str.split(",");
        int[] arr = new int[arrays.length];
        for(int i=0;i<arrays.length;i++){
            arr[i] = Integer.parseInt(arrays[i]);
        }
        int m = sc.nextInt();
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0;i<arr.length;i++){

        }
    }
}