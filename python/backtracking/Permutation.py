class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def __init__(self):
        self.num = []
        self.result = []
    
    def permute(self, num):
        self.num = num
        self.dfs([], self.num)
        return self.result
        
    def dfs(self, valuelist, num_list):
        if len(valuelist) == len(self.num):
            self.result.append(valuelist)
            return
        
        for i in xrange(len(num_list)):
            self.dfs(valuelist+[num_list[i]], num_list[0:i] + num_list[i+1:])

if __name__ == "__main__":
    solution = Solution()
    
    print solution.permute([1, 2, 3])
