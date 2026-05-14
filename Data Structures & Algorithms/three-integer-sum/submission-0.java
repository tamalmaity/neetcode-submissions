class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int sum = -nums[i];
            if (i>0 && nums[i]==nums[i-1]) continue;
                int left = i+1;
                int right = nums.length-1;
                
                while (left<right){
                    int tempSum = nums[left] + nums[right];
                    if (tempSum==sum){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        ans.add(tmp);
                        while (left<right && nums[left]==nums[left+1]) left++;
                        left++;
                        right--;
                    }
                    else if (tempSum<sum) left++;
                    else right--;
                }
        }
        return ans;
    }
}
