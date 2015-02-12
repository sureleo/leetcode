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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (i < m-1) {
            i ++;
            p = p.next;
        }
        ListNode new_tail = p.next;
        i = 0;
        while (i < n-m) {
            ListNode tmp = new_tail.next;
            ListNode tmp1 = p.next;
            p.next = new_tail.next;
            new_tail.next = new_tail.next.next;
            tmp.next = tmp1;
            i++;
        }
        return dummy.next;
    }
}
