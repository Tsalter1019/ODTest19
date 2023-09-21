package com.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 长度不超过nn，且包含子序列“us”的、只由小写字母构成的字符串有多少个？ 答案对10^9+710
 * 9
 *  +7取模。
 * 所谓子序列，指一个字符串删除部分字符（也可以不删）得到的字符串。
 * 例如，"unoacscc"包含子序列"us"，但"scscucu"则不包含子序列"us"
 */
public class tt{
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
    //    long[][] dp = new long[n + 1][3];
    //    // dp[i][0] 代表长度为i的字符串没有u
    //    // dp[i][1] 代表长度为i的字符串有u没有s
    //    dp[1][0] = 25;
    //    dp[1][1] = 1;
    //
    //    long ans = 0;
    //    for (int i = 2; i <= n; i++) {
    //        dp[i][0] = dp[i-1][0] * 25 % 1000000007;
    //        dp[i][1] = (dp[i-1][0] + dp[i-1][1] * 25 % 1000000007) % 1000000007;
    //        dp[i][2] = (dp[i-1][1] + dp[i-1][2] * 26 % 1000000007) % 1000000007;
    //        ans = (ans + dp[i][2]) % 1000000007;
    //    }
    //
    //    System.out.println(ans);
    //

    /*public static void main(String[] args) {
        String line = "W\0O\0R\0K\0G\0R\0O\0U\0P\0";
        char[] charArray = line.toCharArray();
        for (char c : charArray) {
            System.out.println(c + ": " + (int) c);
        }
        System.out.println(line.length()); // 9
        line = line.replace(String.valueOf((char) 61557), "");
        line = line.replace(String.valueOf((char) 61656), "");
        line = line.replace(String.valueOf((char) 61550), "");
        line = line.replace(String.valueOf((char) 61599), "");
        line = line.replace(String.valueOf((char) 61548), "");
        line = line.replace(String.valueOf((char) 61672), "");
        line = line.replace(String.valueOf((char) 8226), "");
        line = line.replace(String.valueOf((char) 8203), "");
        line = line.replace(String.valueOf((char) 160), "");
        System.out.println("line: "+line.length()); // 0
        System.out.println(line);
    }*/
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.YEAR);
        System.out.println(Calendar.MONTH);
        System.out.println(Calendar.DAY_OF_WEEK);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        System.out.println(new Date());
        System.out.println(s);
        System.out.println("ss-"+(4.5*15.5));
        String [] str = s.split("-");
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }
}

