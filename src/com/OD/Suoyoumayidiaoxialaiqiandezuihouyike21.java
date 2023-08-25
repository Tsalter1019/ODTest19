package com.OD;


public class Suoyoumayidiaoxialaiqiandezuihouyike21 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for (int ant : left) {
            lastMoment = Math.max(lastMoment, ant);
        }
        for (int ant : right) {
            lastMoment = Math.max(lastMoment, n - ant);
        }
        return lastMoment;
    }

}