#need to bottom up rather than top down.
#1 hour of my life. XD
#一小时的人生 XD
class Solution:
    # @param dungeon, a list of lists of integers
    # @return a integer
    def calculateMinimumHP(self, dungeon):
        m = len(dungeon)
        n = len(dungeon[0])
        
        opt = [[0 for i in xrange(n)] for i in xrange(m)]
        if dungeon[-1][-1] >= 0:
            opt[-1][-1] = 0
        else:
            opt[-1][-1] = dungeon[-1][-1]

        for i in xrange(m-2, -1, -1):
            temp = opt[i+1][-1] + dungeon[i][-1]
            if temp >= 0:
                opt[i][-1] = 0
            else:
                opt[i][-1] = temp
        
        for i in xrange(n-2, -1, -1):
            temp = opt[-1][i+1] + dungeon[-1][i]
            if temp >= 0:
                opt[-1][i] = 0
            else:
                opt[-1][i] = temp
                
        for i in xrange(m-2, -1, -1):
            for j in xrange(n-2, -1, -1):
                temp = max(opt[i][j+1], opt[i+1][j]) + dungeon[i][j]
                if temp >= 0:
                    opt[i][j] = 0
                else:
                    opt[i][j] = temp
            
        return (0-opt[0][0]) + 1
        
if __name__ == "__main__":
    solution = Solution()

    #print solution.calculateMinimumHP([[0, 0]])
    print solution.calculateMinimumHP([[-200]])

