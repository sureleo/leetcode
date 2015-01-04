# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param preorder, a list of integers
    # @param inorder, a list of integers
    # @return a tree node
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0 or len(inorder) == 0:
            return
        root = TreeNode(preorder[0])
        root_inorder_idx = inorder.index(root.val)
        root.left = self.buildTree(
                        preorder[1:root_inorder_idx+1],
                        inorder[0:root_inorder_idx]
                    )
        root.right = self.buildTree(
                        preorder[root_inorder_idx+1:len(preorder)],
                        inorder[root_inorder_idx+1:len(inorder)]
                    )
            
        return root

if __name__ == "__main__":
    solution = Solution()

    #root = solution.buildTree([1, 2], [2, 1])
    root = solution.buildTree([1, 4, 2, 3], [1, 2, 3, 4])
