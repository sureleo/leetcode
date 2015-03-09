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
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.check(root.left, root.right);
    }
    
    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) {
            return false;
        }
        return this.check(left.left, right.right) && this.check(left.right, right.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        while (left.isEmpty() == false || leftRoot != null) {
            if (leftRoot != null) {
                if (rightRoot == null) {
                    return false;
                }
                left.push(leftRoot);
                right.push(rightRoot);
                leftRoot = leftRoot.left;
                rightRoot = rightRoot.right;
            } else {
                if (right.isEmpty() == true || rightRoot != null) {
                    return false;
                }
                TreeNode currLeft = left.pop();
                TreeNode currRight = right.pop();
                if (currLeft.val != currRight.val) {
                    return false;
                }
                leftRoot = currLeft.right;
                rightRoot = currRight.left;
            }
        }
        return right.isEmpty() && rightRoot == null;
    }
}
}
