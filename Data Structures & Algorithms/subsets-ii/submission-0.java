class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    public void helper(int[]nums, List<Integer>tmp, int ind){
        if(ind==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[ind]);
        helper(nums, tmp, ind+1);
        tmp.remove(tmp.size()-1);
        while((ind+1)<nums.length){
            if (nums[ind]==nums[ind+1]) ind++;
            else break;
        }
        helper(nums, tmp, ind+1);
    }
}
