package Deke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 给定参数n,从1到n会有n个整数:1,2,3,...,n,  这n个数字共有n!种排列. 按大小顺序升序列出所有排列的情况,并一一标记,当n=3时,所有排列如下:
      "123" "132" "213" "231" "312" "321"给定n和k,返回第k个排列.
      输入描述:
        输入两行，第一行为n，第二行为k，
        给定n的范围是[1,9],给定k的范围是[1,n!]。
      输出描述：
        输出排在第k位置的数字。
      实例1：
        输入:
          3
          3
        输出：
          213
        说明
          3的排列有123,132,213...,那么第三位置就是213
      实例2：
        输入
          2
          2
        输出：
          21
        说明
          2的排列有12,21，那么第二位置的为21
   */
public class A80 {
    public static void main(String[] args) {
        System.out.println(new A80().solution(3,3));
    }
    //public static int solutin(int a,int b){
    //    int sum=1;
    //    for(int i=1;i<=a;i++){
    //        sum*=i;
    //    }
    //    return 1;
    //}

    public String solution(int n, int k) {
        //初始化阶乘数组
        int[] factorial = new int[n+1];
        calculateFactorial(factorial,n);
        //查找全排列的布尔数组
        boolean[] temp = new boolean[n+1];
        Arrays.fill(temp,false);
        //动态字符串
        StringBuilder path = new StringBuilder();
        dfs(temp,factorial,0,path,k,n);
        return path.toString();
    }

    private void dfs(boolean[] temp,int factorial[],int index,StringBuilder path,int k,int n){
        if(index == n){
            return;
        }
        //全排列个数
        int cnt = factorial[n-1-index];
        for(int i = 1; i <= n; i++){
            if(temp[i]){
                continue;
            }
            //当时全排列个数
            if(cnt < k){
                k -= cnt;
                continue;
            }
            path.append(i);
            temp[i] = true;
            dfs(temp,factorial,index+1,path,k,n);
            return;
        }
    }

    //计算阶乘数组
    private void calculateFactorial(int[] factorial, int n){
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1]*i;
        }
    }

    public static void solution1(int n,int k){
        StringBuilder sb = new StringBuilder();

        List<Integer> candidates = new ArrayList<>();

        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i = n - 1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index * factorials[i];
        }
        System.out.println(sb);
    }
}