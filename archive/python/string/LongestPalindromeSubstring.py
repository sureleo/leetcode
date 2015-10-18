class Solution:
    # @return a string
    def longestPalindrome(self, s):
        curr_length = 1
        curr_result = s[0]
        for i in xrange(len(s)):
            curr_max = self.expand(i, i, s)
            if len(curr_max) > curr_length:
                curr_length = len(curr_max)
                curr_result = curr_max

        for i in xrange(len(s)-1):
            curr_max = self.expand(i, i+1, s)
            if len(curr_max) > curr_length:
                curr_length = len(curr_max)
                curr_result = curr_max
            
        return curr_result
        
        
    def expand(self, left, right, s):
        while left >= 0 and right <= len(s) - 1 and s[left] == s[right]:
            left -= 1
            right += 1
        
        return s[left+1:right]

if __name__ == "__main__":
    solution = Solution()
    
    print solution.longestPalindrome("aaaa")

