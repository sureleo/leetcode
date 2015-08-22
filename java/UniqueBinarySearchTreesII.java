/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// This problem is "Medium". Are you f^_^king kidding me?
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return this.dfs(1, n);
    }
    
    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i-1);
            List<TreeNode> right = dfs(i+1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
