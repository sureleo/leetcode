# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        if root is None:
            return None
        
        if root.left:
            root.left.next = root.right
        if root.next and root.right:
            root.right.next = root.next.left
        
        self.connect(root.right)
        self.connect(root.left)

if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(1)
    node1 = TreeNode(2)
    node2 = TreeNode(3)
    root.left = node1
    root.right = node2
    solution.connect(root)

