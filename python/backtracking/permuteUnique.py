class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def __init__(self):
        self.num = []
        self.result = []
        self.prev = None
    
    def permuteUnique(self, num):
        self.num = num
        self.dfs([], self.num)
        return self.result
        
    def dfs(self, valuelist, num_list):
        if len(valuelist) == len(self.num):
            self.result.append(valuelist)
            return
        
        for i in xrange(len(num_list)):
            if i > 0 and num_list[i] == num_list[i-1]:
                continue
            self.dfs(valuelist+[num_list[i]], num_list[0:i] + num_list[i+1:])

if __name__ == "__main__":
    solution = Solution()

    #print solution.permuteUnique([1, 1, 2])
    print solution.permuteUnique([1, 1])
