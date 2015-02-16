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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> curr = new ArrayList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        curr.add(root);
        while (curr.isEmpty() == false) {
            List<Integer> curr_result = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            for (int i = 0; i < curr.size(); i++) {
                curr_result.add(curr.get(i).val);
                if (curr.get(i).left != null) {
                    next.add(curr.get(i).left);
                }
                if (curr.get(i).right != null) {
                    next.add(curr.get(i).right);
                }
            }
            curr.clear();
            curr = next;
            result.add(curr_result);
        }
        return result;
    }
}
