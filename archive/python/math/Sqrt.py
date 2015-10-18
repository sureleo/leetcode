class Solution:
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
        if x == 0:
            return 0
        if x == 1:
            return 1
        
        low = 1
        high = x/2 + 1
        
        while low <= high:
            mid = (low + high) / 2
            if mid * mid > x:
                high = mid - 1
            elif mid * mid < x:
                low = mid + 1
            else:
                return mid
                
        return high

if __name__ == "__main__":
    solution = Solution()
    print solution.sqrt(2)
    print solution.sqrt(3)
    print solution.sqrt(5)
        
