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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        ListNode p = headA;
        while (p != null) {
            p = p.next;
            lengthA++;
        }
        int lengthB = 0;
        p = headB;
        while (p != null) {
            p = p.next;
            lengthB++;
        }
        Boolean longerA = true;
        if (lengthB > lengthA) {
            longerA = false;
        }
        int diff = Math.abs(lengthA - lengthB);
        int start = 0;
        ListNode startNode = new ListNode(0);
        ListNode anotherStartNode = new ListNode(0);
        if (longerA == true) {
            startNode = headA;
            anotherStartNode = headB;
        } else {
            startNode = headB;
            anotherStartNode = headA;
        }
        while (start < diff) {
            startNode = startNode.next;
            start ++;
        }
        while (startNode != null && anotherStartNode != null) {
            if (startNode == anotherStartNode) {
                return startNode;
            } else {
                startNode = startNode.next;
                anotherStartNode = anotherStartNode.next;
            }
        }
        return null;
    }
}
