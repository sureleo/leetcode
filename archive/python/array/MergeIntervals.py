# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge(self, intervals):
        result = []
        if len(intervals) == 0:
            return result
            
        intervals = sorted(intervals, key = lambda i: i.start)
        
        result.append(intervals[0])
        i = 1
        while i < len(intervals):
            if intervals[i].start > result[-1].end:
                result.append(intervals[i])
            else:
                result[-1].end = max(intervals[i].end, result[-1].end)
            i += 1
            
        return result
