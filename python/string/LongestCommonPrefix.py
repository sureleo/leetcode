class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        result = ""
        if len(strs) == 0:
            return result
            
        min_length = 10 ** 10
        for i in xrange(len(strs)):
            min_length = min(min_length, len(strs[i]))
            
        for i in xrange(min_length):
            curr = strs[0][i]
            for j in xrange(1, len(strs)):
                if strs[j][i] != curr:
                    return result
            result += curr
        
        return result
                
