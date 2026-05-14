class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        return dfs(0,n,map,0,prices); // 0 is buying state, 1 is selling state
    }

    int dfs(int i, int n, HashMap<List<Integer>,Integer> map, int state, int[]prices){
        if (i>=n) return 0;
        if (map.containsKey(Arrays.asList(i,state))) return map.get(Arrays.asList(i,state));

        if (state==0){
            int buy = dfs(i+1,n,map,1,prices) - prices[i];
            int cooldown = dfs(i+1,n,map,0,prices);
            map.put(Arrays.asList(i,0), Math.max(buy,cooldown));
        }
        else{
            int sell = dfs(i+2,n,map,0,prices) + prices[i];
            int cooldown = dfs(i+1,n,map,1,prices);
            map.put(Arrays.asList(i,1), Math.max(sell,cooldown));
        }
        return map.get(Arrays.asList(i,state));
    }
}
