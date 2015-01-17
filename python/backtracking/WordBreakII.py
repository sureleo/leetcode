class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    def __init__(self):
        self.result = []
        self.s = ""
        self.dict = None
        self.opt = []
    
    def wordBreak(self, s, dict):
        self.s = s
        self.dict = dict
        self.opt = [False for i in xrange(len(self.s)+1)]
        self.opt[0] = True
        for i in xrange(0, len(self.s)):
            for j in xrange(1, len(self.s)):
                if self.opt[i] and self.s[i:j]:
                    self.opt[j] = True
        self.dfs([], self.s)
        return self.result
        
    def dfs(self, valuelist, S):
        if len("".join(valuelist)) == len(self.s):
            valuelist.reverse()
            self.result.append(" ".join(valuelist))
            return
        for i in xrange(len(S)-1, -1, -1):
            if S[i:] in self.dict and self.opt[i]:
                self.dfs(valuelist+[S[i:]], S[0:i])

if __name__ == "__main__":
    solution = Solution()

    print solution.wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"])
    #print solution.wordBreak(
    #    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
    #    ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    #)
