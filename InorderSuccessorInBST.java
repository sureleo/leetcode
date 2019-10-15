/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

// The successor of a node p is the node with the smallest key greater than p.val.

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return findMin(p.right);
        }
        
        TreeNode successor = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > p.val) {
                successor = curr;
                curr = curr.left;
            } else if (curr.val < p.val) {
                curr = curr.right;
            } else {
                break;
            }
        }
        
        return successor;
    }
    
    private TreeNode findMin(TreeNode p) {
        TreeNode curr = p;
        while (curr.left != null) {
            curr = curr.left;
        }
        
        return curr;
    }
}
