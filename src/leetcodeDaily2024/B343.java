package leetcodeDaily2024;

public class B343 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new B343().integerBreak(n));
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0]=dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(j*(i-j),Math.max(j*dp[i-j],dp[i]));
            }
        }
        return dp[n];
    }
}
