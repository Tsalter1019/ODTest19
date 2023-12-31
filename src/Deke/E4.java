package Deke;

/**
 * 一天一只顽猴想要从山脚爬到山顶，
 * 途中经过一个有n个台阶的阶梯，
 * 但是这个猴子有个习惯，每一次只跳1步或3步
 * 试问？猴子通过这个阶梯有多少种不同的跳跃方式
 *
 * 输入只有一个数n， 0 < n < 50
 * 代表此阶梯有多个台阶
 *
 *
 */
public class E4 {
    public static int fib(int n){//fibonacci写法
        if(n == 1 || n == 2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        return fib(n-1) + fib(n-3);
    }

    public static int fib2(int n){//动态规划写法
        int[] arr = new int[n+2];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        for(int i=4;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-3];
        }
        return arr[n];
    }
    public static int fib3(int n){//
        int step1 = 1, step2 = 1, step3 = 2;
        int step4 = n == 1 || n == 2 ? 1 : 2;
        for(int i=4;i<=n;i++){
            step4 = step3 + step1;
            step1 = step2;
            step2 = step3;
            step3 = step4;
        }
        return step4;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(50));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}