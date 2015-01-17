class Solution:
    # @return a ListNode
    def __init__(self):
        self.result = []

    def subsets(self, S):
        self.dfs(0, S, [])
        return self.result

    def dfs(self, start, S, valuelist):
        valuelist.sort()
        self.result.append(valuelist)
        for i in xrange(start, len(S)):
            self.dfs(i+1, S, valuelist+[S[i]]) 

if __name__ == "__main__":
    solution = Solution()

    print solution.subsets([1, 2, 3])
