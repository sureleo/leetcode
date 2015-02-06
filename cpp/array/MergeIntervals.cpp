/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
bool comparator (Interval i, Interval j) {
    return (i.start < j.start);
}

class Solution {
public:
    std::vector<Interval> merge(std::vector<Interval> &intervals) {
        std::sort(intervals.begin(), intervals.end(), comparator);
        std::vector<Interval> result;
        if (intervals.size() == 0) {
            return result;
        }
        int i = 1;
        result.push_back(intervals[0]);
        while (i < intervals.size()) {
            if (intervals[i].start > result.back().end) {
                result.push_back(intervals[i]);
            } else {
                result.back().end = std::max(intervals[i].end, result.back().end);
            }
            i ++;
        }
        return result;
    }
};
