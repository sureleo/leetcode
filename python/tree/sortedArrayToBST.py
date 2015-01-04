# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param num, a list of integers
    # @return a tree node
    def sortedArrayToBST(self, num):
        length = len(num)
        if length == 0:
            return None
            
        return self.convert(0, length-1, num)
        
    def convert(self, low, high, num):
        if low > high:
            return
        mid = (low + high) / 2
        root = TreeNode(num[mid])
        root.left = self.convert(low, mid - 1, num)
        root.right = self.convert(mid + 1, high, num)
        return root

if __name__ == "__main__":
    solution = Solution()

    print solution.sortedArrayToBST([9])
