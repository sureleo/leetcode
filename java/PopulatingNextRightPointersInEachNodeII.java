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
        
        if (root.left != null && root.right == null) {
            TreeLinkNode tmp = root.next;
            this.pointTo(root.left, tmp);
        } else if (root.left == null && root.right != null) {
            TreeLinkNode tmp = root.next;
            this.pointTo(root.right, tmp);
        } else if (root.left != null && root.right != null) {
            root.left.next = root.right;
            TreeLinkNode tmp = root.next;
            this.pointTo(root.right, tmp);
        } else {
            return;
        }
        
        this.connect(root.right);
        this.connect(root.left);
    }
    
    public void pointTo(TreeLinkNode from, TreeLinkNode to) {
        while (to != null) {
            if (to.left != null) {
                from.next = to.left;
                break;
            }
            if (to.right != null) {
                from.next = to.right;
                break;
            }
            to = to.next;
        }
    }
}
