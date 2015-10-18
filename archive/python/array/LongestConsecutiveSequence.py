class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        result = 0
        d = {}
        for i in xrange(len(num)):
            d[num[i]] = 1
        
        for i in xrange(len(num)):
            curr = 1
            d[num[i]] = 0
            left = num[i]-1 
            while left in d and d[left] == 1:
                d[left] = 0
                left -= 1
                curr += 1
            right = num[i]+1
            while right in d and d[right] == 1:
                d[right] = 0
                right += 1
                curr += 1
            result = max(curr, result)
            
        return result
