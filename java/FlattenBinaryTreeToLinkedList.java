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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = new TreeNode(0);
        while (stack.empty() != true || node != null) {
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                lastVisit = node;
                node.right = node.left;
                node.left = null;
                node = node.right;
            } else {
                node = stack.pop();
                lastVisit.right = node;
            }
        }
    }
}
