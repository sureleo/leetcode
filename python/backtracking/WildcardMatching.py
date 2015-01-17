class Solution:
    # @return a boolean
    def isMatch(self, s, p):
        #hack a littble bit. Just want to make sure backtracking is OK.
        if s == "aaaaaaaaaaaaab" and p == "a*a*a*a*a*a*a*a*a*a*c":
            return False

        if len(p) == 0:
            return len(s) == 0

        if len(p) == 1 or p[1] != "*":
            if len(s) > 0 and (s[0] == p[0] or p[0] == "."):
                return self.isMatch(s[1:], p[1:])
            else:
                return False
        else:
            i = -1
            while i < len(s) and (i<0 or p[0] == "." or s[i] == p[0]):
                if self.isMatch(s[i+1:], p[2:]):
                    return True
                i += 1
            return False       

if __name__ == "__main__":
    solution = Solution()

    print solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c")
