package Deke;

import java.util.Scanner;

/**
  小组中每位都有一张卡片 卡片是6位以内的正整数 将卡片连起来可以组成多种数字 计算组成的最大数字
  输入描述：
    ","分割的多个正整数字符串
    不需要考虑非数字异常情况
    小组种最多25个人
   输出描述：
     最大数字字符串
   示例一
     输入
      22,221
     输出
      22221
    示例二
      输入
        4589,101,41425,9999
      输出
        9999458941425101
        9999458941425101
   */
public class E84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int [] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        //int[] arr = {4589,101,41425,9999};
        solution(arr);
    }
    private static void solution(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(compareto(arr[j],arr[j+1])){
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]+"");
        }
    }
    private static boolean compareto(int a,int b){//a>b返回true a<b返回false
        char[] m = (a+"").toCharArray();
        char[] n = (b+"").toCharArray();
        for(int i=0;i<Math.min(m.length,n.length);i++){
            if(m[i]!=n[i]){
                if(m[i]>n[i]){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}