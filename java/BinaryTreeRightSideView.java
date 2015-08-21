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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> curr = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        
        curr.add(root);
        while (curr.isEmpty() == false) {
            List<TreeNode> next = new ArrayList<TreeNode>();
            for (int i = 0; i < curr.size(); i++) {
                if (i == curr.size() - 1) {
                    result.add(curr.get(i).val);
                }
                
                if (curr.get(i).left != null) {
                    next.add(curr.get(i).left);
                }
                
                if (curr.get(i).right != null) {
                    next.add(curr.get(i).right);
                }
            }
            
            curr.clear();
            curr = next;
        }
        
        return result;
    }
}
