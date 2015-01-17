class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def __init__(self):
        self.result = []
        self.S = []
        
    def subsetsWithDup(self, S):
        S.sort()
        self.S = S
        self.dfs(0, [])
        return self.result
    
    def dfs(self, start, valuelist):
        if valuelist not in self.result:
            self.result.append(valuelist)
            
        for i in xrange(start, len(self.S)):
            self.dfs(i+1, valuelist+[self.S[i]])

if __name__ == "__main__":
    solution = Solution()
    
    print solution.subsetsWithDup([1, 2, 2])
