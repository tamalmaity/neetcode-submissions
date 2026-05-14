class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int[] nums, int ind, List<Integer> tmp){
        if(ind==nums.length) return;
        helper(nums, ind+1, tmp);

        tmp.add(nums[ind]);
        ans.add(new ArrayList<>(tmp));

        helper(nums,ind+1,tmp);
        tmp.remove(tmp.size()-1);
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        ans.add(tmp);
        helper(nums,0,tmp);
        return ans;
    }
}
