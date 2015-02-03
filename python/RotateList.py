class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def rotateRight(self, head, k):
        if head is None or head.next is None:
            return head
        
        if k == 0:
            return head

        fast = head
        slow = head
        for i in xrange(k):
            if fast is None:
                fast = head
            fast = fast.next
                
        if fast is None:
            return head
        
        while fast.next is not None:
            fast = fast.next
            slow = slow.next

        result = slow.next
        slow.next = None
        fast.next = head
        
        return result

if __name__ == "__main__":
    solution = Solution()
    l1 = ListNode(1)
    l2 = ListNode(2)
    l3 = ListNode(3)
    l4 = ListNode(4)
    l5 = ListNode(5)
    l1.next = l2
    #l2.next = l3
    #l3.next = l4
    #l4.next = l5

    p = solution.rotateRight(l1, 3)
    while p is not None:
        print p.val
        p = p.next

