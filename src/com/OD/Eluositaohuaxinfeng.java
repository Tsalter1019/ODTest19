package com.OD;

/**
 * 俄罗斯套娃 LIS
 */

import java.util.Arrays;

public class Eluositaohuaxinfeng {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int [] f = new int[n];
        Arrays.sort(envelopes,(e1,e2) -> {
            if(e1[0] == e2[0]) return e2[1] - e1[1];
            return e1[0] - e2[0];
        });
        int res = 0;
        for(int i=0;i<n;i++){
            f[i] = 1;
            for(int j=0;j<i;j++){
                if(envelopes[j][1]<envelopes[i][1]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            res = Math.max(res,f[i]);
        }
        return res;
    }
}