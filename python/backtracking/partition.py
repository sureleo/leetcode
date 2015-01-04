class Solution:
    # @param s, a string
    # @return a list of lists of string
    def __init__(self):
        self.s = ""
        self.result = []
        
    def partition(self, s):
        self.s = s
        self.dfs([], self.s)
        return self.result
        
    def dfs(self, valuelist, S):
        if len("".join(valuelist)) == len(self.s):
            self.result.append(valuelist)
        for i in xrange(len(S)):
            if self.check(S[0:i+1]):
                self.dfs(valuelist+[S[0:i+1]], S[i+1:])
            
    def check(self, s):
        if len(s) == 0:
            return False
        low = 0
        high = len(s) - 1
        while low < high:
            if s[low] != s[high]:
                return False
            low += 1
            high -= 1
        return True

if __name__ == "__main__":
    solution = Solution()

    print solution.partition("aab")
