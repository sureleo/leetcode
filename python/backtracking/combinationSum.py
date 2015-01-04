class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def __init__(self):
        self.result = []
        
    def combinationSum(self, candidates, target):
        candidates.sort()
        self.dfs(0, target, [], candidates)
        return self.result
        
    def dfs(self, start, target, valuelist, candidates):
        if target == 0 and valuelist not in self.result:
            self.result.append(valuelist)
            return
        if target < 0:
            return
        for i in xrange(start, len(candidates)):
            self.dfs(i, target-candidates[i], valuelist+[candidates[i]], candidates)
if __name__ == "__main__":
    solution = Solution()

    print solution.combinationSum([2, 3, 6, 7], 7)
