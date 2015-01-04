class Solution:
    # @return an integer
    def numTrees(self, n):
        if n == 0:
            return 1
        if n == 1:
            return 1
            
        opt = [0 for i in xrange(n+1)]
        opt[0] = 1
        opt[1] = 1
        for i in xrange(2, n+1):
            for j in xrange(i):
                print (i, j)
                opt[i] += opt[i-j-1] * opt[j]
        
        return opt[n]

if __name__ == "__main__":
    solution = Solution()

    #print solution.wordBreak("aaaaaaa", ["aaaa", "aaa"])
    print solution.numTrees(3)
