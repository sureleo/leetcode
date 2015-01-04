class Solution:
    # @param an integer
    # @return a list of string
    def __init__(self):
        self.result = []
        self.n = 0
    
    def dfs(self, l, r, s):
        if l == r and r == self.n:
            self.result.append(s)
            return
        if l < r:
            return
        if l <= self.n:
            self.dfs(l+1, r, s+"(")
        self.dfs(l, r+1, s+")")
        
    def generateParenthesis(self, n):
        self.n = n
        self.dfs(0, 0, "")
        return self.result
        
if __name__ == "__main__":
    solution = Solution()

    print solution.generateParenthesis(3)
