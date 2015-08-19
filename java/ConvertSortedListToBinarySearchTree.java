/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = this.getLength(head);
        return this.createTree(head, length);
    }
    
    public TreeNode createTree(ListNode head, int length) {
        if (head == null || length == 0) {
            return null;
        }
        
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        int mid = length / 2;
        ListNode p = head;
        int step = 0;
        while (step < mid) {
            step += 1;
            p = p.next;
        }
        
        ListNode secondHalf = p.next;
        p.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = this.createTree(head, step);
        root.right = this.createTree(secondHalf, length-1-step);
        return root;
    }
    
    public int getLength(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length += 1;
            p = p.next;
        }
        
        return length;
    }
}
