public class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        ListNode next = node.next;
        while (next.next != null) {
            prev.val = next.val;
            prev = prev.next;
            next = next.next;
        }
        prev.val = next.val;
        prev.next = null;
    }
}
