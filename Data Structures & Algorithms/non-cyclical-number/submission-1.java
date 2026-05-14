class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (n!=1){
            //finding digits and adding the squares
            int sum = 0;
            while(n>0){
                int digit = n%10;
                n/= 10;
                sum += Math.pow(digit,2);
            }
            n=sum;
            if (sum == 1){
                n=1;
                break;
            }
            if (set.contains(sum)){
                break;
            }
            else set.add(sum);
        }
        if (n==1) return true;
        else return false;
    }
}
