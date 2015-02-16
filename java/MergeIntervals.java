/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        if (a.start > b.start) {
            return 1;
        } else if (a.start < b.start) {
            return -1;
        } else {
            return 0;
        }
    }
}
 
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return result;
        }
        result.add(intervals.get(0));
        int i = 1;
        while (i < intervals.size()) {
            if (intervals.get(i).start > result.get(result.size()-1).end) {
                result.add(intervals.get(i));
            } else {
                result.get(result.size()-1).end = Math.max(result.get(result.size()-1).end, intervals.get(i).end);
            }
            i ++;
        }
        return result;
    }
}
