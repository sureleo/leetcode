# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        total = []
        self.dfs(root, 0, total) 
        print total
        return sum(total)
        
    def dfs(self, root, curr, total):
        if root is None:
            return 
        
        if root.left is None and root.right is None:
            curr += root.val
            total.append(curr)
        
        if root.left:
            self.dfs(root.left, (root.val+curr)*10, total)
        
        if root.right:
            self.dfs(root.right, (root.val+curr)*10, total)

if __name__ == "__main__":
    solution = Solution()
    tn0 = TreeNode(9)
    tn1 = TreeNode(0)
    #tn0.left = tn1

    p = solution.sumNumbers(tn0)
