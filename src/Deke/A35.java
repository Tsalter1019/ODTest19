package Deke;

import java.util.LinkedList;
import java.util.List;

/** 同一个数轴x有两个点的集合A={A1,A2,...,Am}和B={B1,B2,...,Bm}   A(i)和B(j)均为正整数 A、B已经按照从小到大排好序，AB均不为空
给定一个距离R 正整数，列出同时满足如下条件的  (A(i),B(j))数对
        1. A(i)<=B(j)
        2. A(i),B(j)之间距离小于等于R
        3. 在满足1，2的情况下每个A(i)只需输出距离最近的B(j)
        4. 输出结果按A(i)从小到大排序

        输入描述
        第一行三个正整数m n R
        第二行m个正整数 表示集合A
        第三行n个正整数 表示集合B

        输入限制 1<=R<=100000   1<=n,m<=100000  1<= A(i),B(j) <= 1000000000

        输出描述
        每组数对输出一行 A(i)和B(j)  以空格隔开

        示例一
        输入
        4 5 5
        1 5 5 10
        1 3 8 8 20

        输出
        1 1
        5 8
        5 8

         */
public class A35 {
    public static void main(String[] args) {
        int[] arr = {4,5,5};
        int[] A = {1,5,5,10};
        int[] B = {1,2,8,8,20};
        System.out.println(solution(arr,A,B));
    }
    public static List<String> solution(int[] arr,int[] A,int[] B){
        List<String> list = new LinkedList<>();
        int m = arr[0];
        int n = arr[1];
        int R = arr[2];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]<=B[j]&&B[j]-A[i]<=R){
                    list.add(A[i]+" "+B[j]);
                    break;
                }
            }
        }
        return list;
    }
}