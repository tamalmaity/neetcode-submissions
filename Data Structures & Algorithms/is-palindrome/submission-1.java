class Solution {
    public boolean isPalindrome(String t) {
        String s = "";
        for (int i=0;i<t.length(); i++)
        {
            if (t.charAt(i)>='A' && t.charAt(i)<='Z') s+= (char)('a'+(t.charAt(i)-'A'));
            else if (t.charAt(i)>='a' && t.charAt(i)<='z') s+= (char)('a'+(t.charAt(i)-'a'));
            else if (t.charAt(i)>='0' && t.charAt(i)<='9') s+= (char)('0'+(t.charAt(i)-'0'));
            //System.out.println(s);
        }

        int sSize = s.length();
        for (int i =0; i<sSize/2; i++)
        {
            if (s.charAt(i) != s.charAt(sSize-i-1))
            {
                return false;
            }
        }
        return true;
    }
}
