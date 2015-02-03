# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        stack = []
        lastVisited = None
        node = root
        result = []
        while len(stack) > 0 or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                curr = stack[-1]
                if not curr.right or lastVisited == curr.right:
                    out = stack.pop()
                    result.append(out.val)
                    lastVisited = out
                else:
                    node = curr.right
        return result
