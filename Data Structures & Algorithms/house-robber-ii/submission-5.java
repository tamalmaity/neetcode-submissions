class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        int[] first = Arrays.copyOfRange(nums, 0, n-1);
        int[] second = Arrays.copyOfRange(nums,1,n);
        int max1 = helper(first);
        int max2 = helper(second);
        return Math.max(max1, max2);
    }

    private int helper(int[] arr){
        int n = arr.length;
        if (n==1) return arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
        }
        return dp[n-1];
    }
}
