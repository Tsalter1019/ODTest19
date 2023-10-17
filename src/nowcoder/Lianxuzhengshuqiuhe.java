package nowcoder;

import java.util.*;

public class Lianxuzhengshuqiuhe {
    public static void main(String[] args) {
        /**
         * 一个整数可以由连续的自然数之和来表示   给定一个整数  计算该整数有几种连续自然数之和的表达式  并打印出每一种表达式
         *         输入描述
         *         一个目标整数t  1<= t <=1000
         *         输出描述
         *         1.该整数的所有表达式和表达式的个数
         *         如果有多种表达式，自然数个数最少的表达式优先输出
         *         2.每个表达式中按自然数递增输出
         *         具体的格式参见样例
         *         在每个测试数据结束时，输出一行"Result:X"
         *         其中X是最终的表达式个数
         *         输入
         *         9
         *         输出
         *         9=9
         *         9=4+5
         *         9=2+3+4
         *         Result:3
         *         说明 整数9有三种表达方法：
         */

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(t + "=" + t);
        solution(t);
        sc.close();
    }
    public static void solution(int t){
        ArrayList<String> res = new ArrayList<>();//定义字符串的集合去接收

        for (int n = 1; n < t; n++) {//从1开始循环  （外层循环累加开头小于输入数 循环就继续）
            int sum = 0;//设置初始值  以及后续循环重置sum值
            StringBuilder builder = new StringBuilder();
            for (int i = n; sum < t; i++) {//(内层循环 和大于输入数就终止)
                sum += i;//累加 1+2+3+4=10  不满足sum<t 回到外层循环
                builder.append(i).append("+");
                if (sum == t) {//和刚好为输入的整数
                    res.add(t + "=" + builder.substring(0, builder.length() - 1));//输出 t= a+b+c...  并截取最后一个"+"
                    break;//跳出当前循环体
                }
            }
        }
        //res.sort(Comparator.comparingInt(String::length));
        //使用的legacyMergeSort和TimSort进行排序
        Collections.sort(res,Comparator.comparingInt(String::length));
        res.forEach(System.out::println);

        System.out.println("Result:" + (res.size() + 1));
    }
}
