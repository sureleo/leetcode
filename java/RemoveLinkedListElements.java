public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode curr = prev.next;
                prev.next = curr.next;
                curr.next = null;
            } else {
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
}
