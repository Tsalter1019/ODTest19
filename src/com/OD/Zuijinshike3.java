package com.OD;

import java.util.Scanner;

/**
 * 力扣681 最近时刻
 */
public class Zuijinshike3 {
    public static String nextClosestTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        while (true) {
            if (++min == 60) {
                min = 0;
                ++hour;
                hour %= 24;
            }
            String curr = String.format("%02d:%02d", hour, min);
            Boolean valid = true;
            for (int i = 0; i < curr.length(); ++i)
                if (time.indexOf(curr.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            if (valid) return curr;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        System.out.println(nextClosestTime(t));
    }
}