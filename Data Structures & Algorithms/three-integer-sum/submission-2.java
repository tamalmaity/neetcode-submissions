class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, List<Integer>> freq = new HashMap<>();
        for (int i=0;i<n;i++){
            List<Integer> tmp;
            if (freq.containsKey(nums[i])){
                tmp = freq.get(nums[i]);
            }
            else{
                tmp = new ArrayList<>();
            }
            tmp.add(i);
            freq.put(nums[i], tmp);
        }

        for (int i=0;i<n;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<n;j++){
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                int sum = nums[i]+nums[j];
                if (freq.containsKey(-sum)){
                    List<Integer> ind = freq.get(-sum);
                    for (Integer k:ind){
                        if (k>j){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
