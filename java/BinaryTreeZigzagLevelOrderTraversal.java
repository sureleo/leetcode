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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Boolean leftToRight = true;
        List<TreeNode> curr = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        curr.add(root);
        while (curr.size() != 0) {
            List<Integer> curr_line = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            if (leftToRight == true) {
                for (int i = curr.size()-1; i>=0; i--) {
                    if (curr.get(i).left != null) {
                        next.add(curr.get(i).left);
                    }
                    if (curr.get(i).right != null) {
                        next.add(curr.get(i).right);
                    }
                    curr_line.add(curr.get(i).val);
                }
            } else {
                for (int i = curr.size()-1; i >= 0; i--) {
                    if (curr.get(i).right != null) {
                        next.add(curr.get(i).right);
                    }
                    if (curr.get(i).left != null) {
                        next.add(curr.get(i).left);
                    }
                    curr_line.add(curr.get(i).val);
                }
            }
            result.add(curr_line);
            leftToRight = !leftToRight;
            curr = next;
        }
        return result;
    }
}
