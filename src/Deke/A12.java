package Deke;

import java.util.Arrays;

/**
 * 一辆运送快递的货车，
 * 运送的快递放在大小不等的长方体快递盒中，
 * 为了能够装载更多的快递同时不能让货车超载，
 * 需要计算最多能装多少个快递。
 * 注：快递的体积不受限制。
 * 快递数最多1000个，货车载重最大50000。
 *
 * 第一行输入每个快递的重量
 * 用英文逗号隔开
 * 如 5,10,2,11
 * 第二行输入货车的载重量
 * 如 20
 *
 * 输出最多能装多少个快递
 * 如 3
 *
 * 5,10,2,11
 * 20
 */
public class A12 {
    public static void main(String[] args) {
        int[] m = {5,10,2,11};
        int n = 20;
        System.out.println(solution(m,n));
    }

    public static int solution(int[] m,int n){
        Arrays.sort(m);
        int sum=0;
        int max=0;
        for(int i=0;i<m.length;i++){
            sum+=m[i];
            if(sum>n){
                break;
            }else{
                max = i+1;
            }
        }
        return max;
    }

}