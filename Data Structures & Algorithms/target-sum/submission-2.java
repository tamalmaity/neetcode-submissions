class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ans = recurse(0, nums, target);
        return ans;
    }

    private int recurse(int i, int[] nums, int target){
        if (i==nums.length){
            if (target==0) return 1;
            else return 0;
        }
        int pos = recurse(i+1,nums,target-nums[i]);
        int neg = recurse(i+1,nums,target+nums[i]);
        return pos+neg;
    }
}
