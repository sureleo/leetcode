public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode skip = pre.next;
        while (skip != null && skip.next != null) {
            while (skip.next != null && skip.next.val == skip.val) {
                skip = skip.next;
            }
            
            if (pre.next != skip) {
                pre.next = skip.next;
                skip.next = null;
                skip = pre.next;
            } else {
                pre = pre.next;
                skip = skip.next;
            }
        }
        
        return dummy.next;
    }
}
