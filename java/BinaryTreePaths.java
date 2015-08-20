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
    public List<String> result = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        
        StringBuilder sb = new StringBuilder();
        this.dfs(root, sb);
        return this.result;
    }
    
    public void dfs(TreeNode root, StringBuilder curr) {
        if (root.left == null && root.right == null) {
            curr.append(root.val);
            result.add(curr.toString());
            return;
        }
        
        if (root.left != null) {
            StringBuilder sb = new StringBuilder(curr);
            sb.append(root.val);
            sb.append("->");
            this.dfs(root.left, sb);
        }
        
        if (root.right != null) {
            StringBuilder sb = new StringBuilder(curr);
            sb.append(root.val);
            sb.append("->");
            this.dfs(root.right, sb);
        }
    } 
}
