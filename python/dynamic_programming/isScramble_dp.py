class Solution:
    # @return a boolean
    def isScramble(self, s1, s2):
        if len(s1) != len(s2):
            return False

        l1 = list(s1)
        l2 = list(s2)
        l1.sort()
        l2.sort()

        if l1 != l2:
            return False

        opt = [[[False for i in xrange(len(s1)+1)] for i in xrange(len(s1))] for i in xrange(len(s1))]

        for i in xrange(len(s1)):
            for j in xrange(len(s2)):
                opt[i][j][0] = True
                opt[i][j][1] = s1[i] == s2[j]

        for l in xrange(2, len(s1)+1):
            for i in xrange(len(s1)-l+1):
                for j in xrange(len(s1)-l+1):
                    for k in xrange(1, l):
                        if (opt[i][j][k] and opt[i+k][j+k][l-k]) or (opt[i][j+l-k][k] and opt[i+k][j][l-k]):
                            opt[i][j][l] = True

        return opt[0][0][len(s1)]

if __name__ == "__main__":
    solution = Solution()

    print solution.isScramble("great", "rgtae")

