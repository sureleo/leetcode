class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        opt = [[0 for i in xrange(n)] for i in xrange(m)]
        for i in xrange(m):
            opt[i][0] = 1
        for j in xrange(n):
            opt[0][j] = 1
        
        for i in xrange(1, m):
            for j in xrange(1, n):
                opt[i][j] = opt[i-1][j] + opt[i][j-1]
        
        return opt[m-1][n-1]

if __name__ == "__main__":
    solution = Solution()

    print solution.uniquePaths(3, 7)
