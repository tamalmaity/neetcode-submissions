class Solution {
    public boolean possible(int[] piles, int h, int r){
        long timetaken = 0;
        for (int i=0;i<piles.length;i++){
            timetaken+= Math.ceil((double)(piles[i])/r);
        }
        if(timetaken<=h) return true;
        else return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int minRate = 1;
        int maxRate = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxRate = Math.max(maxRate, piles[i]);
        }
        int ans = maxRate;
        while (minRate<=maxRate){
            int midRate = minRate + (maxRate-minRate)/2;
            if (possible(piles,h,midRate)){
                ans = midRate;
                maxRate = midRate-1;
            }
            else minRate = midRate+1;
        }
        return ans;
    }
}
