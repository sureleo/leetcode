class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
        if len(s1) + len(s2) != len(s3):
            return False
        
        opt = [[False for i in xrange(len(s2)+1)] for i in xrange(len(s1)+1)]
        opt[0][0] = True
        
        for i in xrange(1, len(s1)+1):
            opt[i][0] = opt[i-1][0] and s1[i-1] == s3[i-1]
        
        for i in xrange(1, len(s2)+1):
            opt[0][i] = opt[0][i-1] and s2[i-1] == s3[i-1]
            
        for i in xrange(1, len(s1)+1):
            for j in xrange(1, len(s2)+1):
                last_of_s3 = s3[i+j-1]
                last_of_s2 = s2[j-1]
                last_of_s1 = s1[i-1]
                if (last_of_s1 == last_of_s3 and opt[i-1][j]) or (last_of_s2 == last_of_s3 and opt[i][j-1]):
                    opt[i][j] = True
        
        return opt[len(s1)][len(s2)]

if __name__ == "__main__":
    solution = Solution()

    print solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")
    print solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")


    print solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab")
