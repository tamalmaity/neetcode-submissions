class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word:wordDict) set.add(word);
        int n = s.length();
        int[] dp = new int[n+1];
        return find(s,set,0, dp);
    }

    private boolean find(String s, HashSet<String>set, int i, int[] dp){
        if (i==s.length()) return true;
        if (dp[i]==1) return true;
        else if (dp[i]==-1) return false;

        for (String word : set){
            int n = word.length();
            if ((i+n)<=s.length() && word.equals(s.substring(i,n+i)))
                if(find(s, set, i+n, dp)){
                    dp[i+n] = 1;
                    return true;
                }
        }
        dp[i] = -1;
        return false;
    }
}
