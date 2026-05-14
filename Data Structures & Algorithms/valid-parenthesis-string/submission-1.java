class Solution {
    public boolean checkValidString(String s) {
        Stack<Character>sLeft = new Stack<>();
        Stack<Character>sStar = new Stack<>();
        for (char c : s.toCharArray()){
            if (c=='(') sLeft.push(c);
            else if (c=='*') sStar.push(c);
            else{
                if (!sLeft.empty() && sLeft.size()>=sStar.size()) sLeft.pop();
                else if (!sStar.empty()) sStar.pop();
                else return false;
            }
        }
        return (sStar.size()>=sLeft.size());
    }
}
