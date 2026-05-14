class Solution {
    public int maxFreq(HashMap<Character,Integer>map){
        int ret = 0;
        for (Character c : map.keySet()){
            if (map.get(c)>ret) ret = map.get(c);
        }
        return ret;
    }
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        int l = 0, r = 0;
        while (r<s.length()){
            Character c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            int maxF = maxFreq(map);
            if ((r-l+1-maxF) <= k){
                ans = Math.max(ans, (r-l+1));
                r++;
            }
            else{
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
                r++;
            }
        }
        return ans;
    }
}
