class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0] = 0;
        for (int i=1;i<(amount+1);i++){
            for (int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && count[i-coins[j]]!=Integer.MAX_VALUE) 
                    count[i] = Math.min(count[i],count[i-coins[j]]+1);
            }
        }
        return count[amount]==Integer.MAX_VALUE?-1:count[amount];
    }
}
