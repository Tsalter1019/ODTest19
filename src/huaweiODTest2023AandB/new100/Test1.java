package huaweiODTest2023AandB.new100;

import java.util.Scanner;

/**
 * 某长方形停车场，每个车位上方都有对应监控器
 * 当且仅当 在当前车位或者前后左右四个方向任意一个车位范围停车时，监控器才需要打开
 * 给出某一时刻停车场的停车分布，请统计最少需要打开多少个监控器
 * 输入描述
 * 第一行输入m，n表示长宽，满足1 < m,n <= 20;
 * 后面输入m行，每行有n个0或1的整数，整数间使用一个空格隔开，表示该行已停车情况，其中0表示空位，1表示已停:
 * 输出
 * 最少需要打开监控器的数量,
 * 输入
 * 3 3
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出
 * 1
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int m = sc.nextInt();
         int n = sc.nextInt();
         int[][] arr = new int[m][n];
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 arr[i][j] = sc.nextInt();
             }
         }
    }
    public static int solution(int m,int n,int[][] arr){
        int count=0;
        int[][] offset = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(arr[x][y]==1){
                    count++;
                    continue;
                }
            }

        }

        return count;
    }
}