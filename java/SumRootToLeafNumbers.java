/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int result = 0;
    
    public int sumNumbers(TreeNode root) {
        this.sum(root, 0);
        return this.result;
    }
    
    public void sum(TreeNode root, int curr) {
        if (root == null) {
            result += curr;
            return;
        }
        
        if (root.left == null && root.right == null) {
            result += curr * 10 + root.val;
            return;
        }
        
        int next = curr * 10 + root.val;
        if (root.left != null) {
            this.sum(root.left, next);
        }
        
        if (root.right != null) {
            this.sum(root.right, next);
        }
    }
}
