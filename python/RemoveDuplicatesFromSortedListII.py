class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def deleteDuplicates(self, head):
        dummy = ListNode(0)
        dummy.next = head
        p = dummy

        while p and p.next:
            slow = p.next
            fast = slow
            while fast.next and fast.next.val == slow.val:
                fast = fast.next
            if fast != slow:
                fast = fast.next
            p.next = fast
            if fast == slow:
                p = p.next

        return dummy.next

if __name__ == "__main__":
    solution = Solution()
    l0 = ListNode(1)
    l1 = ListNode(1)
    l2 = ListNode(2)
    l3 = ListNode(2)
    l0.next = l1
    l1.next = l2
    l2.next = l3

    p = solution.deleteDuplicates(l0)
    while p is not None:
        print p.val
        p = p.next

