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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode tmp = p.next.next;
            p.next.next = tmp.next;
            tmp.next  = p.next;
            p.next = tmp;
            p = p.next.next;
        } 
        return dummy.next;
    }
}
