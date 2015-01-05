class Solution:
    # @return an integer
    def minDistance(self, word1, word2):
        len_1 = len(word1)
        len_2 = len(word2)
        
        opt = [[0 for i in xrange(len_2+1)] for i in xrange(len_1+1)]
        
        for i in xrange(len_1+1):
            opt[i][0] = i
        
        for i in xrange(len_2+1):
            opt[0][i] = i
            
        for i in xrange(1, len_1+1):
            for j in xrange(1, len_2+1):
                if word1[i-1] == word2[j-1]:
                    opt[i][j] = opt[i-1][j-1]
                else:
                    opt[i][j] = min([opt[i-1][j-1], opt[i-1][j], opt[i][j-1]]) + 1
                    
        return opt[len_1][len_2]

if __name__ == "__main__":
    solution = Solution()

    print solution.minDistance("ree", "respse")
    print solution.minDistance("reest", "respse")
