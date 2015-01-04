# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        result = []
        return result

if __name__ == "__main__":
    solution = Solution()
    node3 = TreeNode(3)
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3.left = node1
    node3.right = node2

    print solution.postorderTraversal(node3)
