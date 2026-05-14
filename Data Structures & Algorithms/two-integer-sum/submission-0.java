class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] indices = new int[2];
        HashMap<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++)
        {
            if (numIndex.containsKey(target-nums[i]))
            {
                indices[0] = numIndex.get(target-nums[i]);
                indices[1] = i;
            }
            else
            {
                numIndex.put(nums[i], i);
            }
        }
        return indices;
    }
}
