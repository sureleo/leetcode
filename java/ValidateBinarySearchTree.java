/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        //here need to use Long rather than Integer.
        //I think the only way to avoid edge cases like {MAX_INT} to handle this in recursion
        //which makes the code fairly ugly
        return this.check(root, Long.MAX_VALUE, Long.MIN_VALUE);   
    }
    
    public boolean check(TreeNode root, long root_max, long root_min) {
        if (root == null) {
            return true;
        }
        if (root.val >= root_max || root.val <= root_min) {
            return false;
        }
        return check(root.left, root.val, root_min) && check(root.right, root_max, root.val);
    }
}
