class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if len(prices) == 0:
            return 0

        opt = [0 for i in xrange(len(prices))]
        opt_r = [0 for i in xrange(len(prices))]
        
        minimum = prices[0]
        maximum = prices[-1]
        
        for i in xrange(1, len(prices)):
            if prices[i] < minimum:
                minimum = prices[i]
            opt[i] = max(opt[i-1], prices[i]-minimum)
        
        for i in xrange(len(prices)-2, -1, -1):
            if prices[i] > maximum:
                maximum = prices[i]
            opt_r[i] = max(opt_r[i+1], maximum-prices[i])
        
        result = 0
        for i in xrange(len(prices)):
            curr = opt[i] + opt_r[i]
            if curr > result:
                result = curr
                
        return result

if __name__ == "__main__":
    solution = Solution()

    #print solution.maxProfit([1])
    print solution.maxProfit([2, 7, 1, 8, 3, 20, 7, 15])
