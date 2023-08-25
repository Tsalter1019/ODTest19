package Deke;

/** 有一个N个整数的数组   和一个长度为M的窗口  窗口从数组内的第一个数开始滑动 直到窗口不能滑动为止  每次滑动产生一个窗口  和窗口内所有数的和
   求窗口滑动产生的所有窗口和的最大值

        输入描述
        第一行输入一个正整数N 表示整数个数  0<N<100000
        第二行输入N个整数   整数取值范围   [-100,100]
        第三行输入正整数M   M代表窗口的大小    M<=100000 并<=N
        输出描述
        窗口滑动产生所有窗口和的最大值
        示例一
        输入
        6
        12 10 20 30 15 23
        3
        输出
        68
         */
public class A32 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {12,10,20,30,15,23};
        int m = 3;
        System.out.println(solution(n,arr,m));
    }
    public static int solution(int n,int[] arr,int m){
        int sum=0;
        int max=0;
        for(int i=0;i<arr.length-2;i++){
            sum = arr[i]+arr[i+1]+arr[i+2];
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}