class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        result = 0
        for i in xrange(1, len(prices)):
            diff = prices[i] - prices[i-1]
            if diff > 0:
                result += diff
        
        return result
