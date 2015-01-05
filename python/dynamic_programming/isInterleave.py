class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
        if len(s1) + len(s2) != len(s3):
            return False
            
        if len(s1) == 0:
            return s2 == s3
        
        if len(s2) == 0:
            return s1 == s3
            
        if s1[0] != s3[0] and s2[0] != s3[0]:
            return False
        if s1[0] == s3[0] and self.isInterleave(s1[1:], s2, s3[1:]):
            return True
        elif s2[0] == s3[0] and self.isInterleave(s1, s2[1:], s3[1:]):
            return True
        else:
            return False

if __name__ == "__main__":
    solution = Solution()

    print solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")
    print solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")


    print solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab")
