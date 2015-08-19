public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        TreeNode temp = root.right;
        root.right = this.invertTree(root.left);
        root.left = this.invertTree(temp);
        
        return root;
    }
}
