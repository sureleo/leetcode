public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode curr = root;
        while (stack.isEmpty() == false || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peak = stack.pop();
                count += 1;
                if (count == k) {
                    return peak.val;
                }
                
                curr = peak.right;
            }
        }
        
        return 0;
    }
}
