class Solution:
    # @return a boolean
    def isScramble(self, s1, s2):
        if s1 == s2:
            return True
        
        l1 = list(s1)
        l2 = list(s2)
        l1.sort()
        l2.sort()
        
        if l1 != l2:
            return False
        
        for i in xrange(1, len(s1)):
            if self.isScramble(s1[i:], s2[i:]) and self.isScramble(s1[:i], s2[:i]):
                return True
            if self.isScramble(s1[i:], s2[:len(s1)-i]) and self.isScramble(s1[:i], s2[len(s1)-i:]):
                return True
        
        return False

if __name__ == "__main__":
    solution = Solution()

    print solution.isScramble("great", "rgtae")

