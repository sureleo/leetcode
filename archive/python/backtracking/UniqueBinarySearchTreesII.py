# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @return a list of tree node
    def generateTrees(self, n):
        return self.dfs(1, n)
        
    def dfs(self, start, end):
        if start > end:
            return [None]
        result = []
        for rootval in xrange(start, end+1):
            LeftTree = self.dfs(start, rootval-1)
            RightTree = self.dfs(rootval+1, end)
            for i in LeftTree:
                for j in RightTree:
                    root = TreeNode(rootval)
                    root.left = i
                    root.right = j
                    result.append(root)
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.generateTrees(1)
