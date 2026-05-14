class Solution {
    public boolean isValid(String s) {
        Stack <Character> stck = new Stack <Character> ();
        for (Character c : s.toCharArray())
        {
            if (c=='(' || c=='{' || c=='[')
            {
                stck.push(c);
            }
            else
            {
                if (c==')' && !stck.empty() && stck.peek() == '(') stck.pop();
                else if (c=='}' && !stck.empty() && stck.peek() == '{') stck.pop();
                else if (c==']' && !stck.empty() && stck.peek() == '[') stck.pop();
                else return false;
            }
        }
        return stck.empty();
    }
}
