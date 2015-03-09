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
        int lenA = this.getLength(headA);
        int lenB = this.getLength(headB);
        ListNode pa = headA;
        ListNode pb = headB;
        int diff = lenA - lenB;
        if (diff > 0) {
            return getNode(pa, pb, diff);
        } else {
            return getNode(pb, pa, -diff);
        }
    }
    
    public ListNode getNode(ListNode pa, ListNode pb, int diff) {
        int i = 0;
        while (i < diff) {
            pa = pa.next;
            i += 1;
        }
        while (pa != null && pb != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
    
    public int getLength(ListNode head) {
        int length = 0;
        ListNode p = (head);
        while (p != null) {
            length += 1;
            p = p.next;
        }
        return length;
    }
}
