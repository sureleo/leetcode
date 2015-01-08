class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        opt_old = []
        opt_old.append(1)
        
        for i in xrange(rowIndex):
            opt = [0 for i in xrange(len(opt_old)+1)]
            for j in xrange(len(opt)):
                if j == 0 or j == len(opt_old):
                    opt[j] = 1
                else:
                    opt[j] = opt_old[j] + opt_old[j-1]
            opt_old = opt[:]
        
        return opt_old

if __name__ == "__main__":
    solution = Solution()

    print solution.getRow(3)

