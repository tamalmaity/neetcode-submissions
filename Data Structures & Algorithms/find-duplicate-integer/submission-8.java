class Solution {
    public int findDuplicate(int[] nums) {
        for (int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i])-1;
            if (nums[ind] < 0) return ind+1;
            else nums[ind] = -nums[ind];
        }
        return -1;
    }
}