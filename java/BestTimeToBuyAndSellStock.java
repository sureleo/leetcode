public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0) {
            return result;
        }
        
        int globalMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            globalMin = Math.min(globalMin, prices[i]);
            result = Math.max(result, prices[i] - globalMin);
        }
        
        return result;
    }
}
