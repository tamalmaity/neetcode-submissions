/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> {
            if (a.start==b.start){
                if (a.end==b.end) return 0;
                else if (a.end>b.end) return 1;
                else return -1;
            }
            else{
                if (a.start>b.start) return 1;
                else return -1;
            }
        });
        for (int i=1; i<intervals.size(); i++){
            if (intervals.get(i).start<intervals.get(i-1).end) return false;
        }
        return true;
    }
}
