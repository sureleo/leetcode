class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def __init__(self):
        self.result = []
        
    def combinationSum2(self, candidates, target):
        candidates.sort()
        self.dfs(0, candidates, target, [])
        return self.result
    
    def dfs(self, start, candidates, target, valuelist):
        if target == 0 and valuelist not in self.result:
            self.result.append(valuelist)
            return
        if target < 0:
            return
        for i in xrange(start, len(candidates)):
            self.dfs(i+1, candidates, target-candidates[i], valuelist+[candidates[i]])


if __name__ == "__main__":
    solution = Solution()

    print solution.combinationSum2([32,10,32,5,25,9,18,23,28,24,10,33,6,24,32,18,10,28,17,18,13,22,7,25,22,17,28,13,17,32,19,6,7,17,7,28,21,12,8,6,31,13,34,24,24,31,8,29,16,20,12,25,29,6,15,16,19,30,17,23,27,31,17,29], 28)

