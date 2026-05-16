class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b)->(b[0]-a[0]));
        double maxm = 0.0;
        int ans = 0;
        for (int i=0;i<n;i++){
            double period = (double)(target-arr[i][0])/(arr[i][1]);
            if(period>maxm){
                maxm = period;
                ans++;
            }
        }
        return ans;
    }
}
