#KMP algorithm. can't get it. Just a simple implementation of
#0. https://www.youtube.com/watch?v=2ogqPWJSftE
#and
#1. http://www.cnblogs.com/zuoyuan/p/3698900.html
class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        n = len(haystack)
        m = len(needle)
        if m == 0 or haystack == needle:
            return 0
        prefix = self.prefixMap(needle)
        q = 0
        for i in range(0, n):
            while q > 0 and needle[q] != haystack[i]:
                q = prefix[q - 1]
            if needle[q] == haystack[i]:
                q = q + 1
            if q == m:
                return i - m + 1
        return -1

    def prefixMap(self, needle):
        prefix = [0 for i in xrange(len(needle))]
        a = 0
        for b in xrange(2, len(needle)+1):
            while a > 0 and needle[a] != needle[b-1]:
                a = prefix[a-1]
            if needle[a] == needle[b-1]:
                a += 1
            prefix[b-1] = a
        return prefix

if __name__ == "__main__":
    solution = Solution()

    print solution.strStr("mississippi", "pi")
    print solution.strStr("a", "a")
