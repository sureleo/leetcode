class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0:
            return False
            
        temp = x / 10
        ten = 1
        while temp > 0:
            temp = temp / 10
            ten = ten * 10
            
        while ten >= 10:
            if x / ten != x % 10:
                return False
            x = x % ten
            x = x / 10
            ten = ten / 100
            
        return True

if __name__ == "__main__":
    solution = Solution()

    print solution.isPalindrome(1000021)
