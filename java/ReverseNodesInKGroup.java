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
    public ListNode reverse (ListNode p, int k) {
        int j = 0;
        ListNode new_tail = p.next;
        while (j < k - 1) {
            ListNode tmp = new_tail.next;
            new_tail.next = new_tail.next.next;
            tmp.next = p.next;
            p.next = tmp;
            j += 1;
        }
        return new_tail;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Boolean reverse = true;
        ListNode p = dummy;
        while (true) {
            int i = 0;
            ListNode tmp = p;
            while (i < k) {
                if (tmp.next == null) {
                    reverse = false;
                    break;
                }
                tmp = tmp.next;
                i += 1;
            }
            if (reverse == false) {
                break;
            }
            p = this.reverse(p, k);
        }
        return dummy.next;
    }
}
