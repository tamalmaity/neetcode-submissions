class Solution {
    public int leastInterval(char[] tasks, int k) {
        int n = tasks.length;
        int[] freq = new int[26];
        int maxm = 0;
        for (int i=0;i<n;i++){
            freq[tasks[i]-'A']++;
            maxm = Math.max(maxm, freq[tasks[i]-'A']);
        }
        List<Integer> arr = new ArrayList<>();
        for (int i=0;i<26;i++){
            if (freq[i]==maxm) arr.add(i);
        }
        int ans = 0;
        if (arr.size()==1){
            int spaces = (maxm-1)*k;
            int left = n-maxm;
            if (spaces>left) ans = maxm+spaces;
            else ans = maxm+left;
        }
        else{
            int m = arr.size();
            if (k<m) ans = n;
            else{
                int spaces = (maxm-1)*(k-m+1);
                int left = n - (m*maxm);
                if (spaces>left) ans = maxm*m + spaces;
                else ans = maxm*m + left;
            }
        }
        return ans;
    }
}
