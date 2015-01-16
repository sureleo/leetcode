class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def reverseKGroup(self, head, k):
        if head is None or head.next is None:
            return head
            
        count_head = head
        counter = 0
        while count_head:
            counter += 1
            count_head = count_head.next
        
        if counter < k:
            return head
        
        num_groups = counter / k
        
        dummy = ListNode(0)
        dummy.next = head
        start = dummy
        curr = dummy.next
        for i in xrange(num_groups):
            for j in xrange(k-1):
                t0 = start.next
                t1 = curr.next.next
                start.next = curr.next
                curr.next.next = t0
                curr.next = t1
            start = curr
            curr = curr.next
                
        return dummy.next
                
if __name__ == "__main__":
    solution = Solution()
    l0 = ListNode(1)
    l1 = ListNode(2)
    l2 = ListNode(3)
    l0.next = l1
    l1.next = l2

    p = solution.reverseKGroup(l0, 2)
    while p:
        print p.val
        p = p.next
