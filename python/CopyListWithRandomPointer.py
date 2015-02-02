# Definition for singly-linked list with a random pointer.
class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
        if not head:
            return 

        p = head
        while p:
            new_node = RandomListNode(p.label)
            new_node.next = p.next
            p.next = new_node
            p = p.next.next

        new_p = head
        while new_p:
            if new_p.random:
                new_p.next.random = new_p.random.next
            new_p = new_p.next.next
        
        new_head = head.next
        old_head = head
        temp = new_head
        while temp.next:
            old_head.next = temp.next
            temp.next = temp.next.next
            temp = temp.next
            old_head = old_head.next
        
        temp.next = None
        old_head.next = None
        
        return new_head

if __name__ == "__main__":
    solution = Solution()
    l0 = RandomListNode(-1)

    p = solution.copyRandomList(l0)
    while p is not None:
        print p.label
        p = p.next

