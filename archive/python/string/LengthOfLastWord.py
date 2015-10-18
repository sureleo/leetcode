class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        s = s.strip()
        l = s.split(" ")
        return len(l[-1])
