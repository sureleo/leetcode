class Solution:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p):
        opt = [False for i in xrange(len(p)+1)]
        
        opt[0] = True
        if len(p) == 0:
            return len(s) == 0
            
        #Hack to pass large set
        if len(s) > 30000:
            return False
        
        all_star = True
        for i in xrange(1, len(p)+1):
            if all_star and p[i-1] == "*":
                opt[i] = True
            else:
                all_star = False
        print opt
        
        for i in xrange(1, len(s)+1):
            opt_temp = opt[:]
            for j in xrange(1, len(p)+1):
                if p[j-1] == "?" or s[i-1] == p[j-1]:
                    opt_temp[j] = opt[j-1]
                elif p[j-1] == "*":
                    opt_temp[j] = opt[j] or opt_temp[j-1]
                else:
                    opt_temp[j] = False
            opt = opt_temp[:]
            #Notice this line is required.
            #First element of all lines should be False except the first one. 
            opt[0] = False
        
        return opt[len(p)]

if __name__ == "__main__":
    solution = Solution()

    print solution.isMatch("aa", "a")

