/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode h2 = slow.next;
        slow.next = null;
        
        ListNode h1 = head;
        h2 = this.reverse(h2);
        while (h1 != null && h2 != null) {
            ListNode tmp1 = h1.next;
            ListNode tmp2 = h2.next;
            h1.next = h2;
            h2.next = tmp1;
            h1 = tmp1;
            h2 = tmp2;
        }
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy.next;
        while (tail.next != null) {
            ListNode temp = tail.next;
            tail.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        
        return dummy.next;
    }
}
