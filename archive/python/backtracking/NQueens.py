class Solution:
    # @return a list of lists of string
    def __init__(self):
        self.array = []
        self.result = []
        self.n = 0
        
    def solveNQueens(self, n):
        self.n = n
        for i in xrange(n):
            self.array.append(i+1)
        self.dfs([], self.array)
        return self.result
            
    def construct(self, valuelist):
        one_result = []
        for i in xrange(len(valuelist)):
            line = ""
            for j in xrange(len(valuelist)):
                if (j+1) == valuelist[i]:
                    line += "Q"
                else:
                    line += "."
            one_result.append(line)
        return one_result
            
    def dfs(self, valuelist, array):
        if len(valuelist) == self.n:
            self.result.append(self.construct(valuelist))
            return
        for i in xrange(len(array)):
            if self.check(valuelist, array[i]):
                self.dfs(valuelist+[array[i]], array[:i]+array[i+1:])
            
    def check(self, valuelist, new_value):
        for i in xrange(len(valuelist)):
            if abs(new_value-valuelist[i]) == abs(len(valuelist)-i):
                return False
        return True

if __name__ == "__main__":
    solution = Solution()

    print len(solution.solveNQueens(9))
