// http://codesniper.blogspot.com/2015/03/188-best-time-to-buy-and-sell-stock-iv.html
// I will definitely say I have met this problem before if I'm asked this problem during interview.

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            return solveBigK(prices);
        }
        
        int global[] = new int[k+1];
        int local[] = new int[k+1];
        global[0] = 0;
        local[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                local[j] = Math.max(local[j]+prices[i]-prices[i-1], global[j-1]);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        
        return global[k];
    }
    
    public int solveBigK(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) {
                result += diff;
            }
        }
        
        return result;
    }
}
