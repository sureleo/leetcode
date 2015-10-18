#at first I try to do it in place, but it was too hard.
# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution:
    # @param intervals, a list of Intervals
    # @param newInterval, a Interval
    # @return a list of Interval
    def insert(self, intervals, newInterval):
        if len(intervals) == 0:
            return [newInterval]
        if newInterval.end < intervals[0].start:
            intervals.insert(0, newInterval)
            return intervals 
        if newInterval.start > intervals[-1].end:
            intervals.append(newInterval)
            return intervals

        result = []
        i = 0
        while i < len(intervals):
            if newInterval.start > intervals[i].end:
                result.append(intervals[i])
                i += 1
            else:
                break

        new_start = newInterval.start
        new_end = newInterval.end
        
        while i < len(intervals):
            #notice the corner = case here
            if intervals[i].start <= newInterval.end:
                new_start = min(new_start, intervals[i].start)
                new_end = max(new_end, intervals[i].end)
                i += 1
            else:
                break

        result.append(Interval(new_start, new_end))

        while i < len(intervals):
            result.append(intervals[i])
            i += 1

        return result

    def output(self, intervals):
        for i in xrange(len(intervals)):
            print (intervals[i].start, intervals[i].end)

if __name__ == "__main__":
    i0 = Interval(0, 2)
    i1 = Interval(3, 5)
    i2 = Interval(6, 8)
    i3 = Interval(10, 12)
    i4 = Interval(13, 15)
    newInterval = Interval(4, 7)
    intervals = [i0, i1, i2, i3, i4]
    solution = Solution()
    result = solution.insert(intervals, newInterval)
    solution.output(result)

        


