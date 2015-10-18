# Knows sth new: Radix Sort
# at first, I thought about Counting Sort and Bucket Sort,
# But I don't think this is practical when the range is huge, i.e. [1, INT_MAX]
# radix sort is better, It should be O(10n)
# http://yucoding.blogspot.com/2014/12/leetcode-question-maximum-gap.html
class Solution:
    # @param num, a list of integer
    # @return an integer
    def maximumGap(self, num):
        if len(num) == 0:
            return 0
        maximum = max(num)
        msd = 1
        while maximum / msd >= 10:
            msd *= 10
            
        new_msd = 10
        while new_msd <= msd * 10:
            buckets = [[] for i in xrange(10)]
            for i in xrange(len(num)):
                curr = (num[i] % (new_msd)) / (new_msd / 10)
                buckets[curr].append(num[i])
            num = []
            for i in xrange(len(buckets)):
                num += buckets[i]
            new_msd *= 10
        
        result = 0
        for i in xrange(1, len(num)):
            result = max(num[i] - num[i-1], result)
            
        return result            

if __name__ == "__main__":
    solution = Solution()

    print solution.maximumGap([100, 3, 2, 1])
