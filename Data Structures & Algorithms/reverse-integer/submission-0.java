class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if (x<0){
            neg = true;
            x = -x;
        }

        StringBuilder s = new StringBuilder(Integer.toString(x));
        s.reverse();

        StringBuilder max = new StringBuilder(Integer.toString(Integer.MAX_VALUE));

        if (s.length()>max.length()) return 0;
        else if (s.length()==max.length() && s.charAt(0)>max.charAt(0)) return 0;
        else{
            Integer ans = Integer.parseInt(s.toString());
            if (neg) return -ans;
            else return ans;
        }
    }
}
