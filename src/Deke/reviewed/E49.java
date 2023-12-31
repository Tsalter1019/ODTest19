package Deke.reviewed;

import java.util.Arrays;

/**一辆运送快递的货车。运送的快递均放在大小不等的长方形快递盒中 为了能够装载更多的快递 同时不能让货车超载 需要计算最多能装多少个快递
 快递的体积不受限制 快递数量最多1000个 货车载重量50000
        输入描述：
        第一行输入 每个快递重量 用逗号分隔
        如5,10,2,11
        第二行 输入 货车的载重量
        如20
        不需要考虑异常输入

        输出描述：
        输出最多能装多少个快递

        货车的载重量为20 最多只能放3种快递 5,10,2因此输出3

        示例1：
         输入
         5,10,2,11
         20
         输出
         3

         */

public class E49 {
    public static void main(String[] args) {
        int m=20;
        int[] arr = {5,10,2,11};
        System.out.println(solution(arr,20));
    }
    public static int solution(int[] arr,int m){
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(m-arr[i]>=0){
                count++;
                m-=arr[i];
            }
        }
        return count;
    }
}