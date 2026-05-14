class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer> prevMap = new HashMap<>();
        prevMap.put(-nums[0],1);
        prevMap.put(nums[0], prevMap.getOrDefault(nums[0],0)+1);
        for (int i=1;i<nums.length;i++){
            HashMap<Integer,Integer> currMap = new HashMap<>();
            for (Integer k : prevMap.keySet()){
                int val1 = k+nums[i];
                int val2 = k-nums[i];
                currMap.put(val1,prevMap.get(k)+currMap.getOrDefault(val1,0));
                currMap.put(val2,prevMap.get(k)+currMap.getOrDefault(val2,0));
            }
            prevMap = currMap;
        }
        return prevMap.getOrDefault(target,0);
    }
}