class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean isPalindrome(String s, int i, int j){
        while (i<=j){
            if (s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
    public void dfs(String s, List<String> tmp, int i){
        if (i==s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int j=i;j<s.length();j++){
            if (isPalindrome(s,i,j)){
                tmp.add(s.substring(i,j+1));
                dfs(s,tmp,j+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<String>(), 0);
        return ans;
    }
}
