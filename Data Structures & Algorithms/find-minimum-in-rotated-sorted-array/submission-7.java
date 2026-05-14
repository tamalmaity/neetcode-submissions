class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int l = 0, r = nums.length-1;
        while(l<=r){
            int m = l +(r-l)/2;
            ans = Math.min(ans, Math.min(nums[l],nums[m]));
            if (nums[m]>=nums[l]){
                l=m+1;
            }
            else r=m-1;
        }
        return ans;
    }
}
