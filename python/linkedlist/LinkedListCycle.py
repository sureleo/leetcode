class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        if head is None:
            return None
            
        fast = head
        slow = head
        hasCycle = False
        
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            
            if fast == slow:
                hasCycle = True
                break
        
        if hasCycle is False:
            return None
        else:
            p = head
            while fast != p:
                fast = fast.next
                p = p.next
            return fast

if __name__ == "__main__":
    solution = Solution()
    l0 = ListNode(1)
    l0.next = l0

    p = solution.detectCycle(l0)
    print p.val
