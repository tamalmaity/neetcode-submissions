class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        Arrays.fill(last,-1);
        for (int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }

        List<Integer>ans = new ArrayList<>();
        int i = 0;
        while(i<s.length()){
            int maxm = findLast(i,s,last);
            ans.add(maxm-i+1);
            i=maxm+1;
        }
        return ans;
    }
    private int findLast(int i, String s, int[]last){
        Character c = s.charAt(i);
        int maxm = last[c-'a'];
        for (int j=i+1;j<maxm;j++){
            if (s.charAt(j)!=c && last[s.charAt(j)-'a']!=-1 && last[s.charAt(j)-'a']>maxm){
                last[c-'a']=-1;
                return findLast(j,s,last);
            }
        }
        return maxm;
    }
}
