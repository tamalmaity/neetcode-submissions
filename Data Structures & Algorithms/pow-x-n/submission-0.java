class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        boolean mult = false;
        if (n>0) mult = true;
        else n = -n;
        double ans = 1;
        ans = helper(x, n, mult, ans);
        if (mult) return ans;
        else return 1/ans;
    }

    private double helper( double x, int n, boolean mult, double ans){
        if (n==0) return ans;
        return x*helper(x,n-1,mult,ans);
    }
}
