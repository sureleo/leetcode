# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
        result = []
        if root is None:
            return result
        
        left_to_right = True
        curr_lv = [root]
        while curr_lv:
            curr_line = []
            next_lv = []
            if left_to_right is False:
                for i in xrange(len(curr_lv)-1, -1, -1):
                    curr_line.append(curr_lv[i].val)
                    if curr_lv[i].right:
                        next_lv.append(curr_lv[i].right)
                    if curr_lv[i].left:
                        next_lv.append(curr_lv[i].left)
            else:
                for i in xrange(len(curr_lv)-1, -1, -1):
                    curr_line.append(curr_lv[i].val)
                    if curr_lv[i].left:
                        next_lv.append(curr_lv[i].left)
                    if curr_lv[i].right:
                        next_lv.append(curr_lv[i].right)
            result.append(curr_line)
            curr_lv = next_lv
            left_to_right = not left_to_right
        return result
                    
if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    root.left = node2
    root.right = node3
    node2.left = node4
    node2.right = node5

    print solution.zigzagLevelOrder(root)
