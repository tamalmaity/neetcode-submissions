class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public void helper(int[]nums, int target, List<Integer>tmp, int ind){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(target<0 || ind==nums.length) return;
        tmp.add(nums[ind]);
        helper(nums, target-nums[ind], tmp, ind+1);
        tmp.remove(tmp.size()-1);
        while((ind+1)<nums.length){
            if (nums[ind]==nums[ind+1]) ind++;
            else break;
        }
        helper(nums, target, tmp, ind+1);
        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer>tmp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, tmp, 0);
        return ans;
    }
}
