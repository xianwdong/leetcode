/*Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/

public class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
class Solution {
    public List < Interval > merge(List < Interval > intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList < > ();
        }
        List < Interval > result = new ArrayList < > ();
        Collections.sort(intervals, (i1, i2) - > (i1.start - i2.start));
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}