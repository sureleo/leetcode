import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, rootIndex+1),
            Arrays.copyOfRange(inorder, 0, rootIndex)
        );
        root.right = buildTree(
            Arrays.copyOfRange(preorder, rootIndex+1, preorder.length),
            Arrays.copyOfRange(inorder, rootIndex+1, inorder.length)
        );
        return root;
    }
}
