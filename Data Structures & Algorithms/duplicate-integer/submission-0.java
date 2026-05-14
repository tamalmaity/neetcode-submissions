class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int i : nums)
        {
            if (freqMap.containsKey(i))
            {
                return true;
            }
            else
            {
                freqMap.put(i,1);
            }
        }
        return false;
    }
}
