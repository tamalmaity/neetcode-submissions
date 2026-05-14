class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i:nums) set.add(i);
        int ans = 0;
        for (int i:nums){
            if (set.contains(i-1)) continue;
            int tmp=1;
            while(set.contains(i+1)){
                tmp++;
                set.remove(i+1);
                i++;
            }
            if (tmp>ans) ans = tmp;
        }
    return ans;
    }
}
