/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IterativeSolution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        int depth = 1;
        while (curr.isEmpty() == false) {
            List<TreeNode> next = new ArrayList<TreeNode>();
            for(int i = 0; i < curr.size(); i++) {
                if (curr.get(i).left == null && curr.get(i).right == null) {
                    return depth;
                }
                if (curr.get(i).left != null) {
                    next.add(curr.get(i).left);
                }
                if (curr.get(i).right != null) {
                    next.add(curr.get(i).right);
                }
            }
            depth += 1;
            curr.clear();
            curr = next;
        }
        return depth;
    }
}

public class RecursiveSolution {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        } else {
            return check(root, depth+1);
        }
    }
    
    public int check(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }
        else if (root.left != null && root.right != null) {
            return Math.min(check(root.left, depth+1), check(root.right, depth+1));
        }
        else if (root.left != null) {
            return check(root.left, depth + 1);
        }
        else {
            return check(root.right, depth + 1);
        }
    }
}
