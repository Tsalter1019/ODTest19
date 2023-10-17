package com.algorithm.DP;

/**
 * 容量为4的背包，有以下三种物品，要求装入物品总价值最大且物品不能重复
 * 物品       重量      价格
 * 吉他(G)     1        1500
 * 音响(S)     4        3000
 * 电脑(L)     3        2000
 *
 *
 *
 */

public class PackageProblem {
    static int[] value={0,1500,3000,2000};//物品价格
    static int[] weight={0,1,4,3};//物品重量
    static int bag=4;

    public static int re_OPT(int n,int bag){
        if(n==0){
            return 0;
        }
        if(bag>=weight[n]){
            return Math.max(value[n] + re_OPT(n-1, bag-weight[n]), re_OPT(n-1, bag));
        }else{
            return re_OPT(n-1,bag);
        }
    }

}