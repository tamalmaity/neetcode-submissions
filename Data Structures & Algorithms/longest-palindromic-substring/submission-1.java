class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = null;
        int n = s.length();

        for (int i=0;i<n;i++){
            int l = i;
            int r = i;
            int oddMax = 0;

            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                oddMax = r-l+1;
                if (oddMax>maxLen){
                maxLen = oddMax;
                ans = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            l=i;
            r=i+1;
            int evenMax = 0;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                evenMax = r-l+1;
                if (evenMax>maxLen){
                maxLen = evenMax;
                ans = s.substring(l,r+1);
                }
                l--;
                r++;
            }

        }
        return ans;
    }
}