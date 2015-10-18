class Solution:
    # @return an integer
    def reverse(self, x):
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        result = 0
        negative = 1
        
        if x < 0:
            negative = -1
            x = 0 - x 
            
        temp = x / 10
        ten = 1
        while temp > 0:
            temp = temp / 10
            ten = ten * 10
         
        i = 0 
        while ten > 0:
            curr = x / ten
            
            if negative == 1:
                if INT_MAX / (10 ** i) < curr or (INT_MAX - result - curr * 10 ** i) < 0:
                    return 0
            else:
                if (0-INT_MIN) / (10 ** i) < curr or (0 - INT_MIN - result - curr * 10 ** i) < 0:
                    return 0
                    
            result = result + curr * (10 ** i)
            x = x % ten
            ten = ten / 10
            i += 1
        
        return negative * result

if __name__ == "__main__":
    solution = Solution()
    print solution.reverse(123)
    print solution.reverse(1563847412)
