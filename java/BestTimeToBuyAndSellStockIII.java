public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int opt[] = new int[prices.length];
        int optReverse[] = new int[prices.length];
        
        opt[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            opt[i] = Math.max(prices[i] - min, opt[i-1]);
            min = Math.min(prices[i], min);
        }
        
        optReverse[optReverse.length-1] = 0;
        int max = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--) {
            optReverse[i] = Math.max(max-prices[i], optReverse[i+1]);
            max = Math.max(prices[i], max);
        }
        
        int result = 0;
        for (int i = 0; i < opt.length; i++) {
            result = Math.max(result, opt[i]+optReverse[i]);
        }
        
        return result;
    }
}
