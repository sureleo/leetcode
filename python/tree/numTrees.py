class Solution:
    # @return an integer
    def numTrees(self, n):
        if n <= 1:
            return 1
            
        opt = [0 for i in xrange(n+1)]
        opt[0] = 1
        opt[1] = 1
        for i in xrange(2, n+1):
            k = i - 1
            for j in xrange(0, i):
                opt[i] += opt[k-j] * opt[j]
                
        return opt[-1]

if __name__ == "__main__":
    solution = Solution()

    print solution.numTrees(3)
