package com.OD;

import java.util.HashSet;
import java.util.Set;

/**
 * 连续的子数组和
 */

public class Lianxudezishuzuhe35 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
            Set<Integer> set = new HashSet<>();
            for (int i = 2; i <= n; i++) {
                set.add(sum[i - 2] % k);
                if (set.contains(sum[i] % k)) return true;
            }
            return false;
        }
    }

