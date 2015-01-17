class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        dummy = ListNode(0)
        dummy.next = head
        slow = dummy
        fast = dummy
        i = 0

        while fast.next is not None:
            fast = fast.next
            if i < n:
                i += 1
            else:
                slow = slow.next

        slow.next = slow.next.next
        return dummy.next


if __name__ == "__main__":
    solution = Solution()
    l1 = ListNode(1)
    l2 = ListNode(2)
    l3 = ListNode(3)
    l4 = ListNode(4)
    l5 = ListNode(5)

    solution.removeNthFromEnd(l1, 1)
    p = solution.removeNthFromEnd(l1, 1)
    while p is not None:
        print p.val
        p = p.next
