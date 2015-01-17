class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        
        opt = [[0 for i in xrange(n)] for i in xrange(m)]
        
        hasObstacle = False
        for i in xrange(m):
            if obstacleGrid[i][0] == 0 and not hasObstacle:
                opt[i][0] = 1
            else:
                opt[i][0] = 0
                hasObstacle = True
            
        hasObstacle = False
        for j in xrange(n):
            if obstacleGrid[0][j] == 0 and not hasObstacle:
                opt[0][j] = 1
            else:
                opt[0][j] = 0
                hasObstacle = True
        
        for i in xrange(1, m):
            for j in xrange(1, n):
                if obstacleGrid[i][j] == 1:
                    opt[i][j] = 0
                else:
                    opt[i][j] = opt[i-1][j] + opt[i][j-1]
        
        return opt[m-1][n-1]

if __name__ == "__main__":
    solution = Solution()

    print solution.uniquePathsWithObstacles([[0, 0], [0, 1]])
