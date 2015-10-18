class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX
            
        if dividend == INT_MAX and divisor == 1:
            return INT_MAX
            
        if divisor == 0:
            return INT_MAX
        
        negative = 1
        if (dividend > 0 and divisor < 0) or (dividend < 0 and divisor > 0):
            negative = -1
        
        dividend = abs(dividend)
        divisor = abs(divisor)
        
        d = dividend
        s = divisor
        result = 0
        i = 1
        while d >= divisor:
            while s + s < d:
                s = s + s
                i = i + i
            result += i
            i = 1
            d = d - s
            s = divisor
        return negative * result

if __name__ == "__main__":
    solution = Solution()
    print solution.divide(31, 3)
