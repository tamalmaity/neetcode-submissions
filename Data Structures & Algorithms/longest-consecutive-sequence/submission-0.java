class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
            ArrayList<Integer> tmpAns = new ArrayList<Integer>();
            tmpAns.add(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if (nums[j]==tmpAns.get(tmpAns.size()-1)+1) tmpAns.add(nums[j]);
            }
            if (tmpAns.size()>ans.size()) ans=tmpAns;
        }
        return ans.size();
    }
}
