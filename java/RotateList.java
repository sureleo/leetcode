/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        n = n % this.getLength(head);
        if (n == 0) {
            return head;
        }
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i += 1;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode temp = slow.next;
        fast.next = dummy.next;
        slow.next = null;
        dummy.next = temp;
        return dummy.next;
    }
    
    public int getLength(ListNode head) {
        ListNode p = head;
        int length = 1;
        while (p.next != null) {
            p = p.next;
            length += 1;
        }
        return length;
    }
}
