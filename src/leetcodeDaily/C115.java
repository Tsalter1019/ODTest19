package leetcodeDaily;

//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10⁹ + 7 取模。
// 示例 1：
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit
// 示例 2：
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 提示：
// 1 <= s.length, t.length <= 1000
// s 和 t 由英文字母组成
// Related Topics 字符串 动态规划 👍 1188 👎 0
public class C115 {
    public static void main(String[] args) {
        String s = "bababag";
        String t = "bag";
        System.out.println(new C115().numDistinct(s,t));
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<=m;i++){
            dp[i][0] = 1;
            for(int j=0;j<=n;j++){
                dp[0][j] = 0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
/**
 * 以下给出解法套路和五种实现。
 *
 * 【五种实现】
 *
 * 常规二维dp
 * 交替滚动一维dp
 * 原地滚动一维dp（借助变量正序版）
 * 原地滚动一维dp（逆序版）
 * 原地滚动一维dp（逆序版，最后一行只更新最终答案）
 * 【解法套路四步走】
 *
 * 1）根据问题给出二维dp数组定义。
 *
 * 要求s子序列中t的个数。立刻定义dp[i][j]: s的前i个字符中的t的前j个字符的子序列个数。后续为了方便叙述，dp[i][j]描述为字符串s_i中t_j的个数。
 *
 * 2）分别令两个维度为0，推测边界。
 *
 * dp[0][j]表示s_0中t_j的个数。s_0是空字符串，只有当j=0时，才有dp[0][j] = 1，表示s子空串中有一个t子空串，否则dp[0][j] = 0，因为一个空串不可能包含一个非空串。
 *
 * dp[i][0]表示s_i中t0的个数。t_0是空字符串，显然任何串（包括空串）都含有一个空子串。因此dp[i][0] = 1。
 *
 * 注意到，dp[i][0] = 1实际上已经包含了dp[0][j] = 1的情形。
 *
 * 3）寻找转移方程。
 *
 * dp[i][j]显然要从dp[i-1][?]递推而来。立即思考dp[i-1][j], dp[i-1][j-1]分别与dp[i][j]的关系。
 *
 * 因为少一个字符，自然而然从当前字符着手。考察si的第i个字符(表为s[i])和tj的第j个字符(表为t[j])的关系。
 *
 * 若s[i] ≠ t[j]：那么s_i中的所有t_j子序列，必不包含s[i]，即s_i-1和s_i中tj的数量是一样的，得到该情形的转移方程:
 *
 * dp[i][j] = dp[i-1][j]
 * 若s[i] = t[j]：假设s_i中的所有t_j子序列中，包含s[i]的有a个，不包含的有b个。s_i中包含s[i]的子序列个数相当于s_i-1中t_j-1的个数，不包含s[i]的子序列个数与上一种情况一样，于是得到该情形的转移方程：
 *
 * a = dp[i-1][j-1]
 * b = dp[i-1][j]
 * dp[i][j] = a + b = dp[i-1][j-1] + dp[i-1][j]
 * 4）空间压缩。
 *
 * 也是固定套路，先从二维数组转两个一维数组（交替滚动），再从两个一维数组转一个一维数组（原地滚动），原地滚动时要注意是否需要逆序。可借助变量来实现正序一维滚动dp，也可以不借助变量直接一维逆序滚动dp。
 *
 * 下面给出代码。
 *
 * ==== 二维dp ====
 *
 * class Solution {
 *     public int numDistinct(String s, String t) {
 *         if(s.length() < t.length()) return 0; // s长度小于t时，s中不会出现t
 *         int ns = s.length(), nt = t.length();
 *         char[] chss = s.toCharArray(), chst = t.toCharArray();
 *         int[][] dp = new int[ns + 1][nt + 1];
 *         for(int i = 0; i <= ns; i++) dp[i][0] = 1;
 *         for(int i = 1; i <= ns; i++){
 *             for(int j = 1; j <= nt; j++){
 *                 dp[i][j] = dp[i - 1][j] + (chss[i - 1] == chst[j - 1] ? dp[i - 1][j - 1] : 0);
 *             }
 *         }
 *         return dp[ns][nt];
 *     }
 * }
 * ==== 交替滚动一维dp ====
 *
 * class Solution {
 *     public int numDistinct(String s, String t) {
 *         if(t.length() > s.length()) return 0; // s长度小于t时间直接返回0
 *         int ns = s.length(), nt = t.length();
 *         int[] pre = new int[nt + 1], cur = new int[nt + 1];
 *         char[] chss = s.toCharArray(), chst = t.toCharArray();
 *         pre[0] = 1;
 *         cur[0] = 1; // 当t为空串时，此行是必须的
 *         for(int i = 1; i <= ns; i++){
 *             for(int j = 1; j <= nt; j++){
 *                 if(chss[i - 1] == chst[j - 1]) cur[j] = pre[j - 1] + pre[j];
 *                 else cur[j] = pre[j];
 *             }
 *             pre = Arrays.copyOf(cur, nt + 1); // for(int k = 0; k <= nt; k++) pre[k] = cur[k];
 *         }
 *         return cur[nt];
 *     }
 * }
 * ==== 原地滚动一维dp 【借助变量正序】====
 *
 * class Solution {
 *     public int numDistinct(String s, String t) {
 *         if(s.length() < t.length()) return 0; // s长度小于t时，s中不会出现t
 *         int ns = s.length(), nt = t.length();
 *         char[] chss = s.toCharArray(), chst = t.toCharArray();
 *         int[] dp = new int[nt + 1];
 *         dp[0] = 1;
 *         int pre = dp[0];
 *         for(int i = 1; i <= ns; i++){
 *             for(int j = 1; j <= nt; j++){
 *                 int nextPre = dp[j]; // 相当于二维矩阵中待更新的dp[i][j]的dp[i - 1][j - 1]
 *                 if(chss[i - 1] == chst[j - 1] ) dp[j] += pre;
 *                 pre = nextPre;
 *             }
 *             pre = 1; // 每完成一行要重置该值为1
 *         }
 *         return dp[nt];
 *     }
 * }
 * ==== 原地滚动一维dp 【逆序(无需变量辅助)】====
 *
 * class Solution {
 *     public int numDistinct(String s, String t) {
 *         if(s.length() < t.length()) return 0; // s长度小于t时，s中不会出现t
 *         int ns = s.length(), nt = t.length();
 *         char[] chss = s.toCharArray(), chst = t.toCharArray();
 *         int[] dp = new int[nt + 1];
 *         dp[0] = 1;
 *         for(int i = 1; i <= ns; i++){
 *             for(int j = nt; j > 0; j--){
 *                 if(chss[i - 1] == chst[j - 1] ) dp[j] += dp[j - 1];
 *             }
 *         }
 *         return dp[nt];
 *     }
 * }
 * ==== 原地滚动一维dp 【最后一行只更新dp[nt]】====
 *
 * class Solution {
 *     public int numDistinct(String s, String t) {
 *         if(s.length() < t.length()) return 0; // s长度小于t时，s中不会出现t
 *         int ns = s.length(), nt = t.length();
 *         char[] chss = s.toCharArray(), chst = t.toCharArray();
 *         int[] dp = new int[nt + 1];
 *         dp[0] = 1;
 *         for(int i = 1; i < ns; i++){ // 省一行
 *             for(int j = nt; j > 0; j--){
 *                 if(chss[i - 1] == chst[j - 1] ) dp[j] += dp[j - 1];
 *             }
 *         }
 *         return chss[ns - 1] == chst[nt - 1] ? dp[nt] + dp[nt - 1] : dp[nt]; // 最后一行只需处理dp[nt]
 *     }
 * }*/