class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def reorderList(self, head):
        if head is None or head.next is None:
            return head

        fast = head
        slow = head

        while fast.next and fast.next.next is not None:
            fast = fast.next.next
            slow = slow.next

        second_half = slow.next
        slow.next = None
        first_half = head 

        dummy = ListNode(0)
        dummy.next = second_half
        start = dummy
        first = start.next 
        while first.next:
            t0 = start.next
            t1 = first.next.next
            start.next = first.next
            first.next.next = t0
            first.next = t1

        second_half = dummy.next

        result = ListNode(0)
        result.next = first_half
        while second_half:
            tfh = first_half.next
            tsh = second_half.next
            first_half.next = second_half
            second_half.next = tfh
            first_half = tfh
            second_half = tsh

        return result.next


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

    p = solution.reorderList(l1)
    while p is not None:
        print p.val
        p = p.next
