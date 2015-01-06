#I don't think it is possible to come up the bug free solution without any debugging
class Solution:
    # @return a boolean
    def isMatch(self, s, p):
        opt = [[False for i in xrange(len(p)+1)] for i in xrange(len(s)+1)]
        opt[0][0] = True
        
        stack = []
        if len(p) == 0:
            return len(s) == 0
            
        for i in xrange(1, len(p)+1):
            if len(stack) > 1:
                opt[0][i] = False
            else:
                if p[i-1] != "*":
                    stack.append(i)
                    opt[0][i] = False
                else:
                    stack.pop()
                    opt[0][i] = True
        
        for i in xrange(1, len(s)+1):
            for j in xrange(1, len(p)+1):
                if p[j-1] == "." or s[i-1] == p[j-1]:
                    opt[i][j] = opt[i-1][j-1]
                elif p[j-1] == "*":
                    if p[j-2] != "." and p[j-2] != s[i-1]:
                        opt[i][j] = opt[i][j-2]
                    else:
                        opt[i][j] = opt[i-1][j] or opt[i][j-2]
                else:
                    opt[i][j] = False
        print opt
        
        return opt[len(s)][len(p)]

if __name__ == "__main__":
    solution = Solution()

    print solution.isMatch("aaa", "ab*a*c*a")
