/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution is from http://rainykat.blogspot.com/2017/01/leetcodeuber-450-delete-node-in-bstdfs.html
// We have 4 scenarios in general:
// 1. Root is Null -> return null
// 2. Root.val is greater than key -> we search key in the left tree.
// 3. Root.val is less than key -> we search key in the right tree.
// 4. Root.val the same with key:
//    4.1 if root.left is null, then we return root.right
//    4.2 if root.right is null, then we return root.left
//    4.3 otherwise, we find the first successor of root, replace roots val with successor.val,
//        and remove successor using recursion.
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode successor = findSuccessor(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
                return root;
            }
        }
    }
    
    private TreeNode findSuccessor(TreeNode root) {
        TreeNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        
        return p;
    }
}
