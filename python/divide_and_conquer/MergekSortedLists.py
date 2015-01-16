# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        if len(lists) == 0:
            return None
            
        if len(lists) == 1:
            return lists[0]
        
        if len(lists) == 2:
            return self.mergeTwoLists(lists[0], lists[1])
        
        l1 = self.mergeKLists(lists[:len(lists)/2])
        l2 = self.mergeKLists(lists[len(lists)/2:])
        
        return self.mergeTwoLists(l1, l2)
        
    def mergeTwoLists(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1
            
        dummy = ListNode(0)
        l3 = dummy
        while l1 and l2:
            if l1.val < l2.val:
                l3.next = l1
                l1 = l1.next
            else:
                l3.next = l2
                l2 = l2.next
            l3 = l3.next
        
        if not l1:
            l3.next = l2
        
        if not l2:
            l3.next = l1
        
        return dummy.next
