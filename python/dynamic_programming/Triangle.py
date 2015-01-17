class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        opt = [0 for i in xrange(len(triangle[-1]))]
        temp = [0 for i in xrange(len(triangle[-1]))]
        
        for i in xrange(len(triangle)):
            for j in xrange(len(triangle[i])):
                if j == 0:
                    temp[j] += triangle[i][j]
                elif j == len(triangle[i])-1:
                    temp[j] = opt[j-1] + triangle[i][j] 
                else:
                    temp[j] = min(opt[j], opt[j-1]) + triangle[i][j]
            opt = temp[:]
        
        return min(opt)

if __name__ == "__main__":
    solution = Solution()

    #print solution.minimumTotal([[-10]])
    print solution.minimumTotal([[2], [3,4], [6,5,7], [4,1,8,3]])
