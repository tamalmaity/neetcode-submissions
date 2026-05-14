class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        helper(str, 0, 0, 0, n);
        return ans;
    }
    private void helper(StringBuilder str, int i, int open, int close, int n){
        if (close>open || open>n || close>n) return;
        if (i==2*n){
            if (open==close && open == n){
                String s = str.toString();
                ans.add(s);
            }
            return;
        }
        str.append('(');
        helper(str, i+1, open+1, close, n);
        str.deleteCharAt(str.length()-1);
        str.append(')');
        helper(str, i+1, open, close+1, n);
        str.deleteCharAt(str.length()-1);
    }
}
