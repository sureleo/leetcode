class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        d = {}
        start = 0
        result = 0

        for i in xrange(len(s)):
            if s[i] in d:
                temp = d[s[i]]
                while start <= temp:
                    del d[s[start]]
                    start += 1
            d[s[i]] = i
            if (i - start + 1) > result:
                result = i - start + 1

        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco")
    #print solution.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar")
    #print solution.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco")
    #print solution.lengthOfLongestSubstring("bbmqb")
    #print solution.lengthOfLongestSubstring("abcabcdbb")
