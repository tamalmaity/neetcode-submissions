class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) sum+= nums[i];
        if(sum%2!=0) return false;
        Boolean[][] seen = new Boolean[nums.length][(sum/2)+1];
        return helper(nums, 0, sum/2, seen);
    }

    private boolean helper(int[]nums, int i, int sum, Boolean[][]seen){
        if (sum==0) return true;
        if (sum<0 || i==nums.length) return false;
        if (seen[i][sum]!=null) return seen[i][sum];
        boolean exclude = helper(nums,i+1,sum,seen);
        boolean include = helper(nums,i+1,sum-nums[i],seen);
        boolean ans = include || exclude;
        seen[i][sum] = ans;
        return ans;
    }
}
