public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            leftHeight += 1;
            left = left.left;
        }

        while (right != null) {
            rightHeight += 1;
            right = right.right;
        }

        if (leftHeight == rightHeight) {
            return (2 << (leftHeight - 1)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
