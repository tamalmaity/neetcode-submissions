class Solution {
    int[] ans = new int[31];
    public int climbStairs(int n) {
        if(n==1 || n == 0){
            ans[n] = 1;
            return ans[n];
        }
        ans[n] = climbStairs(n-1) + climbStairs(n-2);
        return ans[n];
    }
}
