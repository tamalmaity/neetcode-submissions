class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return 0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int i = 0, j = 1;
        int remove = 0;
        while (j<n){
            if (intervals[i][1]<=intervals[j][0]){
                i = j;
                j++;
            }
            else{
                if (intervals[i][1]>intervals[j][1]){
                    i = j;
                }
                remove++;
                j++;
            }
        }
        return remove;
    }
}


