class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public void helper(List<Integer> tmp, int[] nums, int ind,int target){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(target<0 || ind==nums.length) return;
        tmp.add(nums[ind]);
        helper(tmp,nums,ind,target-nums[ind]);
        tmp.remove(tmp.size()-1);
        helper(tmp,nums,ind+1,target);
        return;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> tmp = new ArrayList<>();
        helper(tmp, nums, 0, target);
        return ans;
    }
}
