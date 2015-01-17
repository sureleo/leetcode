class Solution:
    # @param s, a string
    # @return an integer
    def minCut(self, s):
        matrix = [[False for i in xrange(len(s))] for i in xrange(len(s))]
        
        for i in xrange(len(s)):
            matrix[i][i] = True
        
        for i in xrange(len(s)-1):
            if s[i+1] == s[i]:
                matrix[i][i+1] = True
            else:
                matrix[i][i+1] = False
                
        for j in xrange(len(s)-2):
            for i in xrange(len(s)-j-2):
                matrix[i][j+i+2] = s[j+i+2] == s[i] and matrix[i+1][i+j+1]

        opt = [0 for i in xrange(len(s)+1)]
        for i in range(len(s)+1):
            opt[i] = len(s) - i
        for i in range(len(s)-1, -1, -1):
            for j in range(i, len(s)):
                if matrix[i][j]:
                    print(i, j)
                    opt[i] = min(1+opt[j+1], opt[i])
        return opt[0]-1

if __name__ == "__main__":
    solution = Solution()

    print solution.minCut("abaca")
