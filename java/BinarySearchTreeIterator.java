/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    public Stack<TreeNode> stack;
    public TreeNode node;
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this.node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (this.stack.isEmpty() == true && this.node == null) {
            return false;
        } else {
            return true;
        }
    }

    /** @return the next smallest number */
    public int next() {
        while (this.stack.isEmpty() == false || this.node != null) {
            if (this.node != null) {
                stack.push(node);
                this.node = this.node.left;
            } else {
                this.node = this.stack.pop();
                int result = this.node.val;
                this.node = this.node.right;
                return result;
            }
        }
        return 0;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
