class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        d = {}
        for i in xrange(len(num)):
            if num[i] not in d:
                d[target-num[i]] = i
            else:
                return (d[num[i]]+1, i+1)
        print d

if __name__ == "__main__":
    solution = Solution()

    print solution.twoSum([3, 2, 4], 6)
