class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        head = 0
        tail = len(s) - 1
        while head < tail:
            if not s[head].isalnum():
                head += 1
                continue
            if not s[tail].isalnum():
                tail -= 1
                continue
            if s[head].lower() != s[tail].lower():
                return False
            else:
                head += 1
                tail -= 1
        
        return True
