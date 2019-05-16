/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                result.add(p.val);
                stack.push(p.right);
                p = p.left;
            } else {
                p = stack.pop();
            }
        }
        
        return result;
    }
}
