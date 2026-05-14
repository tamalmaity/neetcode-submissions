class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m>n) return false;

        int[] cfreq1 = new int[26];
        int[] cfreq2 = new int[26];
        for(int i=0;i<m;i++){
            cfreq1[s1.charAt(i) - 'a']++;
            cfreq2[s2.charAt(i) - 'a']++;
        }
        int flag = 0;
        for(int k = 0;k<26;k++){
                if (cfreq1[k] != cfreq2[k]){
                    flag = 1;
                    break;
                }
        }
        if(flag==0) return true;

        for (int i=m;i<n;i++){
            cfreq2[s2.charAt(i-m)-'a']--;
            cfreq2[s2.charAt(i)-'a']++;
            int k = 0;
            for(;k<26;k++){
                if (cfreq1[k] != cfreq2[k]) break;
            }
            if(k==26) return true;
        }
        return false;
    }
}
