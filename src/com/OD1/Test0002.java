package com.OD1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 讨论
 * 最后编辑
 * Amos
 * 05/03/2023
 * 题目0002-整数对最小和
 * 题目描述
 * 给定两个整数数组 array1 array2
 * 数组元素按升序排列
 * 假设从array1 array2中分别取出一个元素可构成一对元素
 * 现在需要取出K个元素
 * 并对取出的所有元素求和
 * 计算和的最小值
 * 注意：
 * 两对元素如果对应于array1 array2中的两个下标均相同，则视为同一个元素
 *
 * 输入两行数组array1 array2
 * 每行首个数字为数组大小 size( 0 < size <= 100)
 * 0 < array1(i) <= 10000 < array2(i) <= 1000
 * 接下来一行为正整数k (0 < k <= array1.size() * array2.size())
 *
 * 3 1 1 2
 * 3 1 2 3
 * 2
 *
 *
 * 4
 */
public class Test0002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = getArray(sc.nextLine());
        int[] arr2 = getArray(sc.nextLine());
        int k = sc.nextInt();

        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i : arr1) {
            for(int j : arr2) {
                list.add(i+j);
            }
        }

        Integer[] res = new Integer[list.size()];
        list.toArray(res);
        Arrays.sort(res);

        for(int i = 0; i < k; i++) {
            sum += res[i];
        }
        System.out.println(sum);

        sc.close();
    }

    private static int[] getArray(String line1){
        String[] split1 = line1.split("\\s+");
        int[] arr1 = new int[Integer.parseInt(split1[0])];

        for(int i=1;i<split1.length;i++){
            arr1[i-1] = Integer.parseInt(split1[i]);
        }
        return arr1;
    }
}