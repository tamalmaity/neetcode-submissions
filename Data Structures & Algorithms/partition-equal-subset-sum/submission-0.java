class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) sum+= nums[i];
        if(sum%2!=0) return false;
        return helper(nums, 0, sum/2);
    }

    private boolean helper(int[]nums, int i, int sum){
        if (sum==0) return true;
        if (sum<0 || i==nums.length) return false;
        return (helper(nums,i+1,sum) || helper(nums,i+1,sum-nums[i]));
    }
}
