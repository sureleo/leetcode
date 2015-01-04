class Solution:
    # @return a list of lists of string
    def __init__(self):
        self.array = []
        self.result = 0
        self.n = 0
        
    def totalNQueens(self, n):
        self.n = n
        for i in xrange(n):
            self.array.append(i+1)
        self.dfs([], self.array)
        return self.result
            
    def dfs(self, valuelist, array):
        if len(valuelist) == self.n:
            self.result += 1
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

    print solution.totalNQueens(9)
