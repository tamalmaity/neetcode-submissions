class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n==1) return 0;
        int l=0,r=0;
        int maxInd = 0, jump = 0;
        while(r<n){
            for (int i=l;i<=r;i++){
                int tmp = i+nums[i];
                maxInd = Math.max(maxInd,tmp);
            }
            jump++;
            l=r+1;
            r=maxInd;
            if (r==n-1) break;
        }
        return jump;
    }
}
