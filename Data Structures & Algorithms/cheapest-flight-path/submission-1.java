class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i=0;i<k+1;i++){
            int[] tmpDist = Arrays.copyOf(dist,n);
            for (int[] edge : flights){
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];
                if (dist[from]!= Integer.MAX_VALUE && tmpDist[to]>(dist[from]+cost)) 
                    tmpDist[to] = dist[from] + cost;
            }
            dist = Arrays.copyOf(tmpDist,n);
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
