import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        if (newInterval.start > intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        
        while (i < intervals.size()) {
            if (newInterval.start > intervals.get(i).end) {
                result.add(intervals.get(i));
                i += 1;
            } else {
                break;
            }
        }
 
        int new_start = Math.min(newInterval.start, intervals.get(i).start);
        int new_end = newInterval.end;
        while (i < intervals.size()) {
            if (newInterval.end >= intervals.get(i).start) {
                new_end = Math.max(new_end, intervals.get(i).end);
                i += 1;
            } else {
                break;
            }
        }
        Interval insert = new Interval(new_start, new_end);
        result.add(insert);
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Interval i0 = new Interval(1, 5);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i0);
        Interval newInterval = new Interval(2, 3);
        s.insert(intervals, newInterval);
    }
}
