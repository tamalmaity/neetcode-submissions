class Solution {
    public void genString(StringBuilder str, int open, int close, List<String>ans, int n){
        if (str.length()==2*n){
            ans.add(str.toString());
        }
        if(open<n){
            str.append("(");
            open++;
            genString(str,open,close,ans,n);
            str.deleteCharAt(str.length()-1);
            open--;
        }
        if(open>close){
            str.append(")");
            close++;
            genString(str,open,close,ans,n);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder("");
        genString(str,0,0,ans,n);
        return ans;
    }
}