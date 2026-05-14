class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        for (int num:nums) map.put(num, map.getOrDefault(num,0)+1);

        List<HashMap.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (a,b) -> a.getValue().compareTo(b.getValue()));
        int[] ans = new int[k];
        int found = 0;
        for (int i=list.size()-1;i>=0;i--){
            if (found == k) break;
            ans[found++] = list.get(i).getKey();
        }
        return ans;
    }
}
