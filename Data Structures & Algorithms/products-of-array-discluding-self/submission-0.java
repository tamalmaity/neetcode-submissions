class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zeroCnt = 0;
        for (int num:nums){
            if(num==0) zeroCnt++;
        }
        if(zeroCnt>1) return ans;
        else if (zeroCnt==1){
            int zeroInd = -1;
            int val = 1;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==0) zeroInd=i;
                else val*= nums[i];
            }
            ans[zeroInd] = val;
            return ans;
        }
        else{
            int val = 1;
            for (int i=0;i<nums.length;i++){
                val*= nums[i];
            }
            for (int i=0;i<nums.length;i++){
                ans[i] = val/nums[i];
            }
            return ans;
        }
    }
}  
