class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        num.sort()
        low = 0
        high = len(num) - 1
        closest = abs(num[low] + num[high] + num[1] - target)
        result = num[low] + num[high] + num[1]
        while high - low > 1:
            curr = num[low] + num[high]
            for i in xrange(low + 1, high):
                temp = curr + num[i]
                diff = abs(target - temp)
                if diff == 0:
                    return target
                if diff < closest:
                    closest = diff
                    result = temp
            if curr < target:
                low += 1
            elif curr > target:
                high -= 1
            else:
                #pay attention here
                if abs(num[high-1]) > abs(num[low+1]):
                    high -= 1
                else:
                    low += 1
        return result

if __name__ == "__main__":
    solution = Solution()

    #print solution.threeSumClosest([-3, -2, -5, 3, -4], -1)
    print solution.threeSumClosest([-5, -4, -3, -2, 3], -1)
