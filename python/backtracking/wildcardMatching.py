class Solution:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p):
        index_s = 0
        index_p = 0
        ss = 0
        star = -1
        while index_s < len(s):
            return True

if __name__ == "__main__":
    solution = Solution()

    #print solution.isMatch("aa", "a")
    #print solution.isMatch("aa", "aa")
    #print solution.isMatch("aaa", "aa")
    #print solution.isMatch("aa", "*")
    #print solution.isMatch("aa", "a*")
    #print solution.isMatch("ab", "?*")
    #print solution.isMatch("aab", "c*a*b")
    #print solution.isMatch("aaabbaa", "*****c")
    #print solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de")
    print solution.isMatch("iescdfimde", "i*de")
