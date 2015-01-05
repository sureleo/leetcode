class Solution:
    # @return an integer
    def numDistinct(self, S, T):
        m = len(T) + 1
        n = len(S) + 1
        opt = [[0 for i in xrange(n)] for i in xrange(m)]

        for i in xrange(n):
            opt[0][i] = 1

        for i in xrange(1, m):
            for j in xrange(1, n):
                if i > j:
                    continue
                opt[i][j] = opt[i][j-1]
                if S[j-1] == T[i-1]:
                    opt[i][j] += opt[i-1][j-1]

        return opt[len(T)][len(S)]
            
if __name__ == "__main__":
    solution = Solution()

    print solution.numDistinct("rabbbit", "rabbit")
    print solution.numDistinct("ABCDE", "C")
    print solution.numDistinct("AEC", "ABCDE")
    print solution.numDistinct("CBAZTAAABBCTA", "CAT")
    print solution.numDistinct("", "A")
