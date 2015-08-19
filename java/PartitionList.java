/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            if (fast.next.val >= x) {
                fast = fast.next;
            } else if (fast == slow) {
                fast = fast.next;
                slow = slow.next;
            } else {
                ListNode temp = fast.next;
                fast.next = fast.next.next;
                temp.next = slow.next;
                slow.next = temp;
                slow = slow.next;
            }
        }
        
        return dummy.next;
    }
}
