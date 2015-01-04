class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        maxProfit = 0
        minStock = 10 ** 10
        for i in xrange(len(prices)):
            if prices[i] < minStock:
                minStock = prices[i]
            profit = prices[i] - minStock
            if profit > maxProfit:
                maxProfit = profit
        return maxProfit

if __name__ == "__main__":
    solution = Solution()

    print solution.maxProfit([2, 10, 1, 4, 7])
