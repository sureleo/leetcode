class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        this.duplicateList(head);
        this.setRandomPointer(head);
        return this.pullOut(head);
    }
    
    public void duplicateList(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }
    }
    
    public void setRandomPointer (RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
    }
    
    public RandomListNode pullOut (RandomListNode head) {
        RandomListNode oldHead = head;
        RandomListNode newHead = oldHead.next;
        RandomListNode pn = newHead;
        
        while (pn.next != null) {
            oldHead.next = pn.next;
            pn.next = pn.next.next;
            pn = pn.next;
            oldHead = oldHead.next;
        }

        oldHead.next = null;
        
        return newHead;
    }
}
