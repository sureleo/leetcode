class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def sortList(self, head):
        if head is None or head.next is None:
            return head

        fast = head
        slow = head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next

        head1 = head
        head2 = slow.next
        slow.next = None

        head1 = self.sortList(head1)
        head2 = self.sortList(head2)
        head = self.merge(head1, head2)
        return head

    def merge(self, head1, head2):
        if head1 is None:
            return head2
        if head2 is None:
            return head1
        
        dummy = ListNode(0)
        p = dummy
        while head1 and head2:
            if head1.val < head2.val:
                p.next = head1
                head1 = head1.next
                p = p.next
            else:
                p.next = head2
                head2 = head2.next
                p = p.next

        if head1 is None:
            p.next = head2
        if head2 is None:
            p.next = head1

        return dummy.next

if __name__ == "__main__":
    solution = Solution()
    l0 = ListNode(8)
    l1 = ListNode(3)
    l2 = ListNode(7)
    l3 = ListNode(5)
    l4 = ListNode(9)
    l5 = ListNode(1)

    l0.next = l1
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5

    p = solution.sortList(l0)
    while p is not None:
        print p.val
        p = p.next

