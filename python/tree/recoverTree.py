# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return nothing
    def __init__(self):
        self.n1 = None
        self.n2 = None
        self.prev = None

    def inOrder(self, root):
        if root is None:
            return None
        self.inOrder(root.left)
        if self.prev and self.prev.val > root.val:
            if self.n1 is None:
                self.n1 = self.prev
                self.n2 = root
            else:
                self.n2 = root
        self.prev = root
        self.inOrder(root.right)
    
    def recoverTree(self, root):
        self.inOrder(root)
        n1_val = self.n1.val
        n2_val = self.n2.val
        self.n1.val = n2_val
        self.n2.val = n1_val
        return root

if __name__ == "__main__":
    solution = Solution()
    node7 = TreeNode(7)
    node3 = TreeNode(3)
    node2 = TreeNode(2)
    node6 = TreeNode(6)
    node8 = TreeNode(8)
    node9 = TreeNode(9)
    node3.left = node7
    node3.right = node8
    node7.left = node2
    node7.right = node6
    node8.right = node9

    solution.inOrder(node3)
    print solution.n1.val
    print solution.n2.val
