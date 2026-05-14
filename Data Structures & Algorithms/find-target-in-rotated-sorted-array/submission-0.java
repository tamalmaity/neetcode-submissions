class Solution {
    public int search(int[] nums, int target) {
        int minInd = 0;
        int minV = nums[0];
        int sz = nums.length;
        int l=0, r=sz-1;
        while(l<=r){
            if(nums[l]<nums[r]){
                minV = nums[l];
                minInd = l;
                break;
            }

            int m = l+(r-l)/2;
            if(minV>nums[m]){
                minV = nums[m];
                minInd = m;
            }
            if(nums[m]>=nums[l]){
                l=m+1;
            }
            else r=m-1;
        }

        l=minInd;
        r = l+sz-1;

        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m%sz]==target) return (m%sz);
            else if (nums[m%sz]<target) l = m+1;
            else r=m-1;
        }
        return -1;
    }
}
