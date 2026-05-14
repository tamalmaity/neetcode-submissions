class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        if (n==1) return intervals;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        for (int i=0;i<n-1;i++){
            if (intervals[i+1][0]>intervals[i][1]) ans.add(intervals[i]);
            else {
                int[] tmp = intervals[i];
                while((i+1)<n && (intervals[i+1][0]<=tmp[1])){
                    tmp[0] = Math.min(tmp[0], intervals[i+1][0]);
                    tmp[1] = Math.max(tmp[1], intervals[i+1][1]);
                    i++;
                }
                ans.add(tmp);
            }
        }
        if (ans.get(ans.size()-1)[1]>=intervals[n-1][0]){
            ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[n-1][1]);
        }
        else ans.add(intervals[n-1]);
        return ans.toArray(new int[ans.size()][2]);
    }
}
