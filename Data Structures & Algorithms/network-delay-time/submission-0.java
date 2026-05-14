class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        for (int i=0;i<n+1;i++){
            if (i==k) dist[i] = 0;
            else dist[i] = Integer.MAX_VALUE;
        }
        boolean[] seen = new boolean[n+1];

        List<List<int[]>> adj = new ArrayList<>(n+1);
        for (int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] tmp:times){
            int a=tmp[0], b= tmp[1], c = tmp[2];
            adj.get(a).add(new int[]{b,c});
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] tmp2 = pq.poll();
            int node = tmp2[0], d = tmp2[1];
            if (seen[node]) continue;
            List<int[]> tmp1 = adj.get(node);
            for (int[] tmp3:tmp1){
                int to = tmp3[0];
                int d1 = tmp3[1];
                if(dist[to]>(d+d1)){
                    dist[to] = d+d1;
                    pq.offer(new int[]{to,dist[to]});
                }
            }
            seen[node] = true;
        }

        int time = Integer.MIN_VALUE;
        for (int i=1;i<n+1;i++){
            if (!seen[i]) return -1;
            time = Math.max(time, dist[i]);
        }
        return time;
    }
}
