class Solution:
    # @return a string
    def getPermutation(self, n, k):
        if n == 0:
            return "0"
            
        num_list = []
        for i in xrange(n):
            num_list.append(str(i+1))
            
        total = 1
        result = ""
        for i in xrange(n):
            total *= (i+1)
            
        for i in xrange(n, 0, -1):
            count = total / i
            index = (k - 1) / count
            result += num_list[index]
            total = count
            k = k - (count * index)
            num_list = num_list[0:index] + num_list[index+1:]
            
        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.getPermutation(4, 6)
