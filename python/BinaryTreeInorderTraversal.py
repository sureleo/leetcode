# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
        stack = []
        node = root
        result = []
        while len(stack) > 0 or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                peak = stack.pop()
                result.append(peak.val)
                node = peak.right
        return result
