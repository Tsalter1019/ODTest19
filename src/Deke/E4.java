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
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        return fib(n-1) + fib(n-3);
    }

    public static void main(String[] args) {
        System.out.println(fib(50));
    }
}