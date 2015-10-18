class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        if len(needle) == 0:
            return 0
        for i in xrange(len(haystack)):
            k = i
            j = 0
            if len(haystack) - k >= len(needle):
                for j in xrange(len(needle)):
                    if k == len(haystack) or needle[j] != haystack[k]:
                        break
                    else:
                        k += 1
                        if j == len(needle) - 1:
                            return k - j - 1
        return -1

if __name__ == "__main__":
    solution = Solution()

    print solution.strStr("ippi", "pi")
    print solution.strStr("aaa", "aaaa")
