package Deke;

import java.util.*;

/**给定一个数组 编写一个函数 来计算他的最大N个数和最小N个数的和 需要对数组进行去重
            说明
            第一行输入M  M表示数组大小
            第二行输入M个数    表示数组内容
            第三行输入N表示需要计算的最大最小N的个数
            输出描述
            输出最大N个数和最小N个数的和
            例一：
                输入
                5
                95 88 83 64 100
                2
                输出
                342

                说明
                最大2个数[100 95] 最小2个数[83 64]      输出342

             例二
                输入
                5
                3 2 3 4 2
                2

                输出
                 -1
                 说明
                 最大两个数是[4 3]最小2个数是[3 2] 有重叠输出为-1    */
public class A28 {
    public static void main(String[] args) {
        int m = 5;
        int[] arr = {95,88,83,64,100};
        //int[] arr = {3,2,3,4,2};
        int n = 2;
        System.out.println(solution(m,arr,n));
    }
    public static int solution(int m,int[] arr,int n){
        int sum=0;
        Set<Integer> set = new LinkedHashSet<>();
        for(int i:arr){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] bigger = new int[n];
        int[] littler = new int[n];
        int latter = list.size()-1;
        int former = 0;
        if(n<m&&list.size()-n>=0){
            for(int i=0;i<bigger.length;i++){
                for(int j=latter;j>=list.size()-n;j--){
                    bigger[i] = list.get(j);
                    latter--;
                    break;
                }
            }
            for(int i=0;i<littler.length;i++){
                for(int j=former;j<n;j++){
                    littler[i] = list.get(j);
                    former++;
                    break;
                }
            }
        }
        for(int i=0;i<bigger.length;i++){
            for(int j=0;j<littler.length;j++){
                if(bigger[i]==littler[j]){
                    return -1;
                }
            }
        }

        for(int i:bigger){
            sum+=i;
        }
        for(int j:littler){
            sum+=j;
        }

        return sum;
    }
}