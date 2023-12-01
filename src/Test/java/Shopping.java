package Test.java;

/**
 * 牛牛带着 n元钱去超市买东西，超市一共只有两款商品，价格为 a元的篮球和价格为 b元的足球，牛牛想把手里的钱尽可能花光，
 * 请问牛牛最少能剩多少钱？
 *
 * 输入一行，三个正整数 n,a,b(1≤n,a,b≤1000)，n表示牛牛现有的钱数，a表示一个篮球的单价，b表示一个足球的单价。
 * 输出一行一个整数，代表牛牛最少能剩下的钱数。
 * 7 5 3
 * 1
 */
public class Shopping {
    public static int solution(int n,int a, int b){
        int p = n/a;
        //int q = n/b;
        //int ba = Math.max(p,q);
        int min=n;
        for(int i=0;i<=p;i++){
            for(int j=(n-a*i)/b;j>=0;j--){
                if(a*i+b*j>n){
                    break;
                }else{
                    int ss = n-a*i-b*j;
                    if(ss<min){
                        min = ss;
                    }
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(solution(7,3,5));
    }
}