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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = l1;
        p2.next = l2;
        int carry = 0;
        while (p1.next != null && p2.next != null) {
            p2.next.val = p1.next.val + p2.next.val + carry;
            carry = p2.next.val / 10;
            p2.next.val = p2.next.val % 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1.next != null) {
            p2.next = p1.next;
        }
        while (p2.next != null) {
            p2.next.val = p2.next.val + carry;
            carry = p2.next.val / 10;
            p2.next.val = p2.next.val % 10;
            p2 = p2.next;
        }
        if (carry==1) {
            ListNode c = new ListNode(1);
            p2.next = c;
        }
        return l2;
    }
}
