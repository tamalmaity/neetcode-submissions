class Solution {
    public int maxProduct(int[] nums) {
        int maxPosEndingHere = nums[0];
        int maxNegEndingHere = nums[0];
        int maxGlobal = nums[0];
        int n = nums.length;
        for (int i=1;i<n;i++){
            int tmp = maxPosEndingHere;
            maxPosEndingHere = Math.max(nums[i], Math.max(maxPosEndingHere*nums[i], maxNegEndingHere*nums[i]));
            maxNegEndingHere = Math.min(nums[i], Math.min(tmp*nums[i], maxNegEndingHere*nums[i]));
            maxGlobal = Math.max(maxGlobal,maxPosEndingHere);
        }
        return maxGlobal;
    }
}
