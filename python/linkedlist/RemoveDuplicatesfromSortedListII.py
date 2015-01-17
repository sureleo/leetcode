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
        tmp = p.next

        while p.next:
            while tmp.next and p.next.val == tmp.next.val:
                tmp = tmp.next
            if p.next == tmp:
                tmp = tmp.next
                p = p.next
            else:
                p.next = tmp.next

        return dummy.next

if __name__ == "__main__":
    solution = Solution()
    l0 = ListNode(1)
    l1 = ListNode(2)
    l2 = ListNode(3)
    l3 = ListNode(3)
    l4 = ListNode(4)
    l5 = ListNode(4)
    l6 = ListNode(5)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6

    p = solution.deleteDuplicates(l0)
    while p is not None:
        print p.val
        p = p.next

