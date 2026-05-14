class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return ans;
    }

    public void helper(int[]nums, List<Integer>tmp, boolean[]seen){
        if(tmp.size() == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(!seen[i]){
                tmp.add(nums[i]);
                seen[i] = true;
                helper(nums, tmp, seen);
                tmp.remove(tmp.size()-1);
                seen[i] = false;
            }
        }
    }
}
