class Solution {
public:
    std::vector<Interval> insert(std::vector<Interval> &intervals, Interval newInterval) {
        std::vector<Interval> result;
        if (intervals.size() == 0) {
            result.push_back(newInterval);
            return result;
        }
        if (newInterval.end < intervals[0].start) {
            intervals.insert(intervals.begin(), newInterval);
            return intervals;
        }
        if (newInterval.start > intervals[int(intervals.size()-1)].end) {
            intervals.push_back(newInterval);
            return intervals;
        }
        int i = 0;
        while (i < int(intervals.size())) {
            if (newInterval.start > intervals[i].end) {
                result.push_back(intervals[i]);
                i ++;
            } else {
                break;
            }
        }
        
        int new_start = newInterval.start;
        int new_end = newInterval.end;
        
        while (i < int(intervals.size())) {
            if (intervals[i].start <= newInterval.end) {
                new_start = std::min(new_start, intervals[i].start);
                new_end = std::max(new_end, intervals[i].end);
                i ++;
            } else {
                break;
            }
        }
        
        result.push_back(Interval(new_start, new_end));
        
        while (i < int(intervals.size())) {
            result.push_back(intervals[i]);
            i ++;
        }
        
        return result;
    }
};
