/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode sorted = head;
        while (sorted.next != null) {
            if (sorted.next.val >= sorted.val) {
                sorted = sorted.next;
            } else {
                ListNode p = dummy;
                while (p.next.val < sorted.next.val) {
                    p = p.next;
                }
                
                ListNode tmp = sorted.next;
                sorted.next = sorted.next.next;
                tmp.next = p.next;
                p.next = tmp;
            }
        }
        
        return dummy.next;
    }
}
