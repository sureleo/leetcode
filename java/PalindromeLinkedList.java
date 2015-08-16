public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode newSecondHalf = reverseList(secondHalf);
        while (firstHalf != null && newSecondHalf != null) {
            if (firstHalf.val != newSecondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            newSecondHalf = newSecondHalf.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode temp = p.next;
            p.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }
}
