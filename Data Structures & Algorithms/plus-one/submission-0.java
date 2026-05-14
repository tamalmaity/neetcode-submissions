class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i=digits.length-1;i>=0;i--){
            int val;
            if (i==digits.length-1) val=digits[i]+1;
            else val = digits[i]+carry;
            if (val==10){
                digits[i] = 0;
                carry = 1;
            }
            else{
                digits[i] = val;
                carry = 0;
            }
        }
        if (carry==0) return digits;
        else{
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carry;
            for (int i=0;i<digits.length;i++) newDigits[i+1] = digits[i];
            return newDigits;
        }
    }
}
