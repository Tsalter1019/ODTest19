package Deke;

import com.algorithm.CAS.Main;

/**
 * 如果三个正整数A、B、C ,A²+B²=C²则为勾股数
 * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，
 * 则称其为勾股数元组。
 * 请求出给定n~m范围内所有的勾股数元组
 *
 * 起始范围         1 < n < 10000       n < m < 10000
 *
 * ABC保证A<B<C
 * 输出格式A B C
 * 多组勾股数元组，按照A B C升序的排序方式输出。
 * 若给定范围内，找不到勾股数元组时，输出Na。
 *
 * 1
 * 20
 *
 * 3 4 5
 * 5 12 13
 * 8 15 17
 *
 * 5
 * 10
 *
 * Na
 */
public class E1 {
    public static void main(String[] args) {
        //System.out.println(isCoprime(6,5));
    }
    //public static List<Integer> solution(int n,int m){
    //}

    //判断两数是否互质
    public static boolean isCoprime(int a,int b,String as ){
        int m = as.length();
        if(a==b){
            return false;
        }
        int min = Math.min(a,b);
        for(int i=2;i<=min;i++){
            if(a%i==0&&b%i==0){
                return false;
            }
        }
        return true;
    }
}