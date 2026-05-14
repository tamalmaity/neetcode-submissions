class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int ans = 0, tmp = 0;
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                tmp++;
            }
            else{
                ans = Math.max(ans,tmp);
                int sInd = i-tmp;
                while(s.charAt(sInd)!=s.charAt(i)){
                    set.remove(s.charAt(sInd));
                    sInd++;
                }
                tmp = i-sInd;
            }
        }
        ans = Math.max(ans,tmp);
        return ans;
    }
}
