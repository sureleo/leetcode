public class Solution {
    public boolean isValidBST(TreeNode root) {
        return this.validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        
        if ((max != null && root.val >= max.intValue()) || (min != null && root.val <= min.intValue())) {
            return false;
        }
        
        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    } 
}
