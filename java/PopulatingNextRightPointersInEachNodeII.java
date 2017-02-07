/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }    
        
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : getRootNextFirstChild(root.next);
        }
        
        if (root.right != null) {
            root.right.next = getRootNextFirstChild(root.next);
        }
        
        connect(root.right);
        connect(root.left);
    }
    
    private TreeLinkNode getRootNextFirstChild(TreeLinkNode root) {
        TreeLinkNode p = root;
        while (p != null) {
            if (p.left != null) {
                return p.left;
            }
            
            if (p.right != null) {
                return p.right;
            }
            
            p = p.next;
        }
        
        return null;
    }
}
