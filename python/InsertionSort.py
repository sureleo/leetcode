class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def insertionSortList(self, head):
        if head is None or head.next is None:
            return head
            
        dummy = ListNode(-10**10)
        dummy.next = head
        p = dummy.next
        
        while p.next:
            if p.next.val > p.val:
                p = p.next
            else:
                curr = dummy
                while curr.next.val < p.next.val:
                    curr = curr.next
                tmp = p.next.next
                p.next.next = curr.next
                curr.next = p.next
                p.next = tmp
        
        return dummy.next

if __name__ == "__main__":
    solution = Solution()
    l1 = ListNode(2)
    l2 = ListNode(1)
    l1.next = l2

    p = solution.insertionSortList(l1)
    while p is not None:
        print p.val
        p = p.next
