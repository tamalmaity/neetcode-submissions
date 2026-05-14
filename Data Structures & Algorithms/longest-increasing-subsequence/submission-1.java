class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxm = dp[0];
        for (int i=1;i<n;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[j]<nums[i]){
                    if (dp[j]+1>dp[i]) {
                        dp[i] = dp[j]+1;
                        maxm = Math.max(maxm, dp[i]);
                    }
                }
            }
        }
        // for (int i=0;i<n;i++) System.out.println(dp[i]+" ");
        return maxm;
    }
}
