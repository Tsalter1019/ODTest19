package com.OD;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据身高重建队列
 */

public class Genjushengaochongjianduilie24 {
    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if(person1[0]!=person2[0]){
                    return person1[0]-person2[0];
                }else{
                    return person2[1]-person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for(int[] person : people) {
            int spaces = person[1] + 1;
            for(int i = 0; i < n; ++i){
                if(ans[i] == null){
                    --spaces;
                    if(spaces == 0){
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}