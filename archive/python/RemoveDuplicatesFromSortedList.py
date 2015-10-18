class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head is None or head.next is None:
            return head
        
        dummy = ListNode(0)
        dummy.next = head
        p = dummy
        while p.next and p.next.next:
            if p.next.next.val == p.next.val:
                p.next = p.next.next
            else:
                p = p.next

        return dummy.next

if __name__ == "__main__":
    solution = Solution()
    l1 = ListNode(1)
    l2 = ListNode(1)
    l3 = ListNode(2)
    l4 = ListNode(3)
    l5 = ListNode(3)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5

    p = solution.deleteDuplicates(l1)
    while p is not None:
        print p.val
        p = p.next
