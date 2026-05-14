class Solution {
    public int[][] insert(int[][] intervals, int[] arr) {
        List<int[]>ans = new ArrayList<>();
        int n = intervals.length, i = 0;
        while (i<n && arr[0]>intervals[i][1]){
            ans.add(intervals[i]);
            i++;
        }

        while (i<n && arr[1]>=intervals[i][0]){
            arr[0] = Math.min(arr[0], intervals[i][0]);
            arr[1] = Math.max(arr[1], intervals[i][1]);
            i++;
        }

        ans.add(arr);
        while (i<n){
            ans.add(intervals[i]);
            i++;
        }
        int[][] ret = new int[ans.size()][2];
        for (i=0;i<ans.size();i++){
            ret[i][0] = ans.get(i)[0];
            ret[i][1] = ans.get(i)[1];
        }
        return ret;
    }
}
