public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if (length == 0) {
            return null;
        }
        
        int realK = k % length;
        if (realK == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        int i = 0;
        while (i < realK) {
            i++;
            fast = fast.next;
        }
        
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        fast.next = dummy.next;
        dummy.next = temp;
        return dummy.next;
    }
    
    private int getLength(ListNode head) {
        ListNode p = head;
        int result = 0;
        
        while (p != null) {
            p = p.next;
            result ++;
        }
        
        return result;
    }
 }
