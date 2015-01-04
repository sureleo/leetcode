class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a boolean
    def wordBreak(self, s, dict):
        opt = [False for i in xrange(len(s)+1)]
        start = 0
        opt[0] = True
        for i in xrange(0, len(s)+1):
            for j in xrange(1, len(s)+1):
                if s[i:j] in dict and opt[i]:
                    opt[j] = True
        print opt
        return opt[len(s)] 

if __name__ == "__main__":
    solution = Solution()

    #print solution.wordBreak("aaaaaaa", ["aaaa", "aaa"])
    print solution.wordBreak("a", ["a"])
