/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    List<String> list = new ArrayList<String>();
    public void mySerialize(TreeNode root) {
        if (root == null) {
            list.add("#");
            return;
        }

        list.add(Integer.toString(root.val));
        mySerialize(root.left);
        mySerialize(root.right);
    }

    public TreeNode myDeserialize() {
        if (list.size() == 0 || list.get(0).equals("#")) {
            if (list.size() != 0) {
                list = list.subList(1, list.size());
            }

            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list = list.subList(1, list.size());
        root.left = myDeserialize();
        root.right = myDeserialize();
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        mySerialize(root);
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return myDeserialize();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
