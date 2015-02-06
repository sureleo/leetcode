/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *p = dummy;
        while (p && p->next) {
            ListNode *slow = p->next;
            ListNode *fast = slow;
            while (fast->next && fast->next->val == slow->val) {
                fast = fast->next;
            }
            if (fast != slow) {
                fast = fast->next;
            }x
            p->next = fast;
            if (fast == slow) {
                p = p->next;
            }
        }
        return dummy->next;
    }
};
