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
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> curr = new ArrayList<Integer>();
        this.dfs(curr, root, sum);
        return this.result;
    }
    
    public void dfs(List<Integer> curr, TreeNode root, int sum) {
        if (root == null) {
            return;
        } else if (root.val == sum && root.left == null && root.right == null) {
            curr.add(root.val);
            this.result.add(curr);
            return;
        } else {
            List<Integer> copy_left = new ArrayList<Integer>(curr);
            copy_left.add(root.val);
            List<Integer> copy_right = new ArrayList<Integer>(copy_left);
            this.dfs(copy_left, root.left, sum-root.val);
            this.dfs(copy_right, root.right, sum-root.val);
        }
    }
}
