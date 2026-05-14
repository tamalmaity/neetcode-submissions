class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        boolean mult = false;
        if (n>0) mult = true;
        else n = -n;
        double ans = helper(x, n, mult);
        if (mult) return ans;
        else return 1/ans;
    }

    private double helper( double x, int n, boolean mult){
        if (n==0) return 1;
        double tmp = helper(x,n/2,mult);
        if (n%2==0) return tmp*tmp;
        else return (x*tmp*tmp);
    }
}
