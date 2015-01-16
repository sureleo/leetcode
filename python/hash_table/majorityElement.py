class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        d = {}
        for i in xrange(len(num)):
            if num[i] not in d:
                d[num[i]] = 1
            else:
                d[num[i]] += 1
        
        for key in d:
            if d[key] > len(num)/2:
                return key

if __name__ == "__main__":
    solution = Solution()

    print solution.majorityElement([8, 8, 7, 7, 7])
