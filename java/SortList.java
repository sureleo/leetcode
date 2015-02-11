/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode f_half = head;
        ListNode s_half = slow.next;
        slow.next = null;
        ListNode head1 = this.sortList(f_half);
        ListNode head2 = this.sortList(s_half);
        ListNode new_head = this.merge(head1, head2);
        return new_head;
    }

    public ListNode merge(ListNode f_half, ListNode s_half) {
        if (f_half == null) {
            return s_half;
        }
        if (s_half == null) {
            return f_half;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while ((f_half != null) && (s_half != null)) {
            if (f_half.val > s_half.val) {
                p.next = s_half;
                s_half = s_half.next;
            } else {
                p.next = f_half;
                f_half = f_half.next;
            }
            p = p.next;
        }
        if (f_half != null) {
            p.next = f_half;
        }
        if (s_half != null) {
            p.next = s_half;
        }
        return dummy.next;
    }
}
