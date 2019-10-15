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
    private void mySerialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("#");
            return;
        }

        list.add(Integer.toString(root.val));
        mySerialize(root.left, list);
        mySerialize(root.right, list);
    }

    private TreeNode myDeserialize(LinkedList<String> list) {
        if (list.size() == 0 || list.get(0).equals("#")) {
            if (list.size() != 0) {
                list.remove(0);
            }

            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = myDeserialize(list);
        root.right = myDeserialize(list);
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<String>();
        mySerialize(root, list);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringArray = data.split(",");
        LinkedList<String> stringList = new LinkedList<>();
        
        for (int i = 0; i < stringArray.length; i++) {
            stringList.add(stringArray[i]);
        }
        
        return myDeserialize(stringList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
