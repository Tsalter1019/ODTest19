package nowcoder.OD108;

/**
 * 对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。
 * 输入：
 * "ababc"
 * 返回值：
 * 3
 * 说明：
 * 最长的回文子串为"aba"与"bab"，长度都为3
 * 输入：
 * "abbba"
 * 返回值：
 * 5
 * 输入：
 * "b"
 * 返回值：
 * 1
 */
public class BM73 {
    public static void main(String[] args) {
        System.out.println(new BM73().getLongestPalindrome("ababc"));
    }
    public int getLongestPalindrome (String A) {
        int m = A.length();
        int[][] dp = new int[m+1][m+1];
        if("".equals(A)){
            return 0;
        }

        int maxLen=1;
        for(int j=0;j<m;j++){
            for(int i=0;i<=j;i++){
                if(i==j){
                    dp[i][j]=1;
                }else{
                    boolean b = A.charAt(i) == A.charAt(j);
                    if(i+1==j&&b){
                        dp[i][j]=1;
                    }else if(b&&dp[i+1][j-1]==1){
                        dp[i][j]=1;
                    }
                    if(dp[i][j]==1&&j-i+1>maxLen){
                        maxLen=j-i+1;
                    }
                }
            }
        }
        return maxLen;
    }
}