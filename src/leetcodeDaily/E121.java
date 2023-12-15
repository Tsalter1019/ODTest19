package leetcodeDaily;

/**
 * 买卖股票的最佳时机1
 *
 */
public class E121 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(new E121().maxProfit(arr));
    }
    //f[i][j]
    //f[i][0]   第i天后不持有股票的最大利润,j=0
    //f[i][1]   第i天后持有股票的最大利润,j=1
    //1.第i天不持有股票（前一天不持有|前一天持有了今天卖）    f[i][0] = Max(f[i-1][0],f[i-1][1]+prices[i])
    //2.第i天持有股票（前一天就持有|前一天不持有今天买）      f[i][1] = Max(f[i-1][1],-prices[i])
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[][] arr = new int[n][2];
        arr[0][0] = 0;
        arr[0][1] = -prices[0];

        for(int i=1;i<n;i++){
            arr[i][0] = Math.max(arr[i-1][0],arr[i-1][1] + prices[i]);
            arr[i][1] = Math.max(arr[i-1][1],-prices[i]);
        }
        return arr[n-1][0];
    }

    //f[i] = max(f[i-1],prices[i] - min(prices[1......,i-1]))
    //1.第i天的最大利润 若没有交易 就是第i-1天的最大利润  2.若交易 就是第i天的股价和前i-1天最小股价的差值
    //上述二者取较大值
    public int maxProfit1(int[] prices){
        int n = prices.length;
        int[] arr = new int[n];
        int minPrice = prices[0];
        for(int i=1;i<n;i++){
            arr[i] = Math.max(arr[i-1],prices[i] - minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return arr[n-1];
    }

    //优化
    public int maxProfit2(int[] prices){
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1;i<n;i++){
            maxProfit = Math.max(maxProfit,prices[i] - minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
