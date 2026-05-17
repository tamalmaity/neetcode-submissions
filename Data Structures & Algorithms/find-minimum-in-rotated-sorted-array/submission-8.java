class Solution {
    public int findMin(int[] nums) {
        int ans = 0;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if (nums[l]<nums[m]){
                if(nums[m]<nums[r]) return nums[l];
                else l=m;
            }
            else if (nums[m]<nums[r]){
                r=m;
            }
            else{
                ans = Math.min(nums[l], Math.min(nums[m], nums[r]));
                break;
            }
        }
        return ans;
    }
}
