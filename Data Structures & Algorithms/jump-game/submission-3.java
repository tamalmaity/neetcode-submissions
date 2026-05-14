class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n==1) return true;
        int toReach = n-1;
        int at = n-2;
        while (at>=0){
            if((nums[at]+at)>=toReach){
                toReach = at;
            }
            at--;
        }
        if (toReach == 0) return true;
        else return false;
    }
}
