class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        i = 1
        result = 0
        while n / (5 ** i) > 0:
            result += n / (5 ** i)
            i += 1
        
        return result
