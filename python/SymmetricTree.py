# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class RecursiveSolution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        if root is None:
            return True
            
        return self.check(root.left, root.right)
        
    def check(self, left, right):
        if (not left and right) or (left and not right):
            return False
        if not left and not right:
            return True
        if left.val != right.val:
            return False
        return self.check(left.right, right.left) and self.check(left.left, right.right)

class IterativeSolution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        if not root:
            return True
            
        stack_left = []
        stack_right = []
        
        node_left = root.left
        node_right = root.right
        
        if (not node_left and node_right) or (node_left and not node_right):
            return False
            
        while len(stack_left) > 0 or node_left:
            if node_left:
                if not node_right:
                    return False
                stack_left.append(node_left)
                node_left = node_left.right
                stack_right.append(node_right)
                node_right = node_right.left
            else:
                if node_right or len(stack_right) == 0:
                    return False
                curr_left = stack_left[-1]
                curr_right = stack_right[-1]
                if curr_left.val != curr_right.val:
                    return False
                node_left = curr_left.left
                node_right = curr_right.right
                stack_left.pop()
                stack_right.pop()
        
        if len(stack_right) != 0 or node_right:
            return False
        
        return True
