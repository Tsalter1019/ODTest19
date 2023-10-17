package nowcoder;

import java.util.Scanner;

/**
 * 骰子是一个正方体，每个面有一个数字，初始为左1 右2 前3 后4 上5 下6 用123456表示这个状态，放置在平面上，
 * 可以向左翻转（用L表示向左翻转1次）   可以向右翻转 （用R表示向右翻转1次）
 * 可以向前翻转（用F表示向前翻转1次）   可以向右翻转 （用B表示向后翻转1次）
 * 可以逆时针翻转（用A表示向左翻转1次） 可以顺时针翻转 （用C表示向右翻转1次）
 * 现从初始状态开始，根据输入的动作序列，计算得到最终的状态。
 * 输入描述：
 * 初始状态为：123456
 * 输入只包含LRFBAC的字母序列，最大长度为50，可重复
 * 输出描述：输出最终状态
 * 输入例子 : RA
 * 输出例子：436512
 */

public class Zhitouzi {

    static StringBuffer sb = new StringBuffer("123456");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        in.close();
        for (String s : split) {
            changeNum(s.charAt(0));
        }
        System.out.print(sb);

    }

    private static  void changeNum(char a) {
        switch (a) {
            case 'L'://向左翻转1次
                String str1 = new StringBuffer(sb.substring(0,2)).reverse().toString();
                sb.replace(0,2,sb.substring(4,6)).replace(4, 6, str1);
                break;
            case 'R'://向右翻转1次
                String str2 = new StringBuffer(sb.substring(4,6)).reverse().toString();
                sb.replace(4,6,sb.substring(0,2)).replace(0, 2, str2);
                break;
            case 'F'://向前翻转1次
                String str3 = new StringBuffer(sb.substring(2,4)).reverse().toString();
                sb.replace(2,4,sb.substring(4,6)).replace(4, 6, str3);
                break;
            case 'B'://向后翻转1次
                String str4 = new StringBuffer(sb.substring(4,6)).reverse().toString();
                sb.replace(4,6,sb.substring(2,4)).replace(2, 4, str4);
            case 'A'://顺时针翻转1次
                String str5 = new StringBuffer(sb.substring(2,4)).reverse().toString();
                sb.replace(2,4,sb.substring(0,2)).replace(0, 2, str5);
                break;
            case 'C'://逆时针翻转1次
                String str6 = new StringBuffer(sb.substring(0,2)).reverse().toString();
                sb.replace(0,2,sb.substring(2,4)).replace(2, 4, str6);
                break;
        }
    }
}
