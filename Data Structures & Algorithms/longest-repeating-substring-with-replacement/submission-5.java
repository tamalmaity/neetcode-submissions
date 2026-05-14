class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int l = 0, r = 0, ans = 0;
        while(r<n){
            freq[s.charAt(r)-'A']++;
            while (!conditionMet(freq,r,l,k)){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }

    private boolean conditionMet(int[]freq, int r, int l, int k){
        int total = r-l+1;
        int maxm = 0;
        for (int i=0;i<26;i++){
            maxm = Math.max(maxm, freq[i]);
        }
        if (total-maxm>k) return false;
        else return true;
    }
}
