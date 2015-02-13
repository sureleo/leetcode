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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        List<Integer> result = new ArrayList<Integer>();
        while ((stack.empty() != true) || (node != null)) {
            if (node != null) {
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            } else {
                node = stack.pop();
            }
        }
        return result;
    }
}
