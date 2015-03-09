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
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<TreeNode>();
        Stack<TreeNode> qs = new Stack<TreeNode>();
        TreeNode proot = p;
        TreeNode qroot = q;
        while (ps.isEmpty() == false || proot != null) {
            if (proot != null) {
                if (qroot == null) {
                    return false;
                }
                ps.push(proot);
                qs.push(qroot);
                proot = proot.left;
                qroot = qroot.left;
            } else {
                if (qs.isEmpty() == true || qroot != null) {
                    return false;
                }
                TreeNode currp = ps.pop();
                TreeNode currq = qs.pop();
                if (currp.val != currq.val) {
                    return false;
                }
                proot = currp.right;
                qroot = currq.right;
            }
        }
        return (qs.isEmpty() && qroot == null);
    }
}
