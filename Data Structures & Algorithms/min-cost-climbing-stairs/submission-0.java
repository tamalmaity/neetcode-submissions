class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 0;
        for (int i=2;i<=n;i++){
            ans[i] = Math.min(cost[i-1]+ans[i-1], cost[i-2]+ans[i-2]);
        }
        return ans[n];
    }
}
