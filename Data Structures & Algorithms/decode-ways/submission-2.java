class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for (int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if (c=='0') continue;
            dp[i] = dp[i+1];
            if ((i+1)<n && (c=='1' || (c=='2' && (s.charAt(i+1)-'0')<7))) dp[i]+= dp[i+2];
        }
        return dp[0];
    }
}
