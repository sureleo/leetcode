import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(
            Arrays.copyOfRange(inorder, 0, rootIndex),
            Arrays.copyOfRange(postorder, 0, rootIndex)
        );
        root.right = buildTree(
            Arrays.copyOfRange(inorder, rootIndex+1, inorder.length),
            Arrays.copyOfRange(postorder, rootIndex, postorder.length-1)
        );
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {-1};
        int[] postorder = {-1};
        Solution sol = new Solution();
        sol.buildTree(inorder, postorder);
    }
}
