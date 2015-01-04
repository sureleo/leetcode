class Solution:
    # @return a list of integers
    def __init__(self):
        self.result = []
        self.n = 0

    def grayCode(self, n):
        self.n = n
        start = ""
        for i in xrange(n):
            start += "0"
        self.dfs([start])
        return self.result

    def dfs(self, valuelist):
        if len(valuelist) == 2**self.n:
            for i in xrange(len(valuelist)):
                if valuelist[i] == "":
                    valuelist[i] = "0"
                valuelist[i] = int(valuelist[i], 2)
            self.result += valuelist
            return
        for i in xrange(self.n-1, -1, -1):
            if len(self.result) > 0:
                break
            new_item = ""
            if valuelist[-1][i] == "0":
                new_item += valuelist[-1][0:i] + "1" + valuelist[-1][i+1:]
            else:
                new_item += valuelist[-1][0:i] + "0" + valuelist[-1][i+1:]
            if new_item not in valuelist:
                self.dfs(valuelist+[new_item])

if __name__ == "__main__":
    solution = Solution()

    import time
    print solution.grayCode(1)
