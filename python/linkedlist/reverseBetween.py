class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        if head is None or head.next is None:
            return head

        dummy = ListNode(0)
        dummy.next = head
        start = dummy
        for i in xrange(m-1):
            if start.next:
                start = start.next

        needsToMove = n - m
        first = start.next
        for i in xrange(2):
            t0 = start.next
            t1 = first.next.next
            start.next = first.next
            first.next.next = t0
            first.next = t1

        return dummy.next
        

if __name__ == "__main__":
    solution = Solution()
    l1 = ListNode(1)
    l2 = ListNode(2)
    l3 = ListNode(3)
    l4 = ListNode(4)
    l5 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5

    p = solution.reverseBetween(l1, 2, 4)
    while p is not None:
        print p.val
        p = p.next
