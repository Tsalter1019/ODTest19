package com.OD;

import java.util.Scanner;

/**
 * 连续整数求和
 */

public class Lianxuzhengshuqiuhe38 {
        public static int consecutiveNumbersSum(int N) {
            int ans = 0;
            for (int start = 1; start <= N; ++start) {
                int target = N, x = start;
                while (target > 0)
                    target -= x++;
                if (target == 0) ans++;
            }
            return ans;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(consecutiveNumbersSum(m));
    }
    }
