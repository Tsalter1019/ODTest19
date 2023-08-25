package com.OD;

/**
 * 括号的最大嵌套深度
 */
public class Kuohaodezuidaqiantaoshendu49 {
        public int maxDepth(String s) {
            int ans = 0, size = 0;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    ++size;
                    ans = Math.max(ans, size);
                } else if (ch == ')') {
                    --size;
                }
            }
            return ans;
        }
    }
