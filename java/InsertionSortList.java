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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-2147483648);
        dummy.next = head;
        ListNode p = dummy;
        while ((p != null) && (p.next != null)) {
            if (p.next.val >= p.val) {
                p = p.next;
            } else {
                ListNode tmp = dummy;
                while (tmp.next.val < p.next.val) {
                    tmp = tmp.next;
                }
                ListNode new_tmp = p.next;
                p.next = p.next.next;
                new_tmp.next = tmp.next;
                tmp.next = new_tmp;
            }
        }
        return dummy.next;
    }
}
