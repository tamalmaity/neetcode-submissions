class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int maxProfit = 0, leftPtr = 0, rightPtr = 1;
        while(rightPtr < prices.length)
        {
            if (prices[rightPtr] <= prices[leftPtr])
            {
                leftPtr = rightPtr;
            }
            else
            {
                maxProfit = Math.max(maxProfit, prices[rightPtr] - prices[leftPtr]);
            }
            rightPtr++;
        }

        return maxProfit;
    }
}
