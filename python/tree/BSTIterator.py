class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator:
    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.stack = []
        self.curr = root

    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        if len(self.stack) == 0 and not self.curr:
            return False
        else:
            return True
        

    # @return an integer, the next smallest number
    def next(self):
        while len(self.stack) > 0 or self.curr:
            if self.curr:
                self.stack.append(self.curr)
                self.curr = self.curr.left
            else:
                temp = self.stack.pop()
                self.curr = temp.right
                return temp.val


# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
if __name__ == "__main__":
    root = TreeNode(1)
    i = BSTIterator(root)
    v = []
    while i.hasNext():
        v.append(i.next())

    print v
