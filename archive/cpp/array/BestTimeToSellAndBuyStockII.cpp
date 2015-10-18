class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int result = 0;
        for (int i = 1; i < int(prices.size()); i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0) {
                result += diff;
            }
        }
        return result;
    }
};
