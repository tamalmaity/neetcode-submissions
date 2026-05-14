class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i=0;i<points.length;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j=i+1;j<points.length;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                map.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{j,dist});
                map.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{i,dist});
            }
        }

        HashSet<Integer> seen = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]-b[0]));
        pq.offer(new int[]{0,0});
        int ans = 0;
        while (seen.size()!=points.length){
            int[] tmp = pq.poll();
            int ind = tmp[1];
            int d = tmp[0];
            if (seen.contains(ind)) continue;
            seen.add(ind);
            ans+= d;
            for (int[] adj : map.getOrDefault(ind, Collections.emptyList())){
                int nextInd = adj[0];
                int nextD = adj[1];
                pq.offer(new int[]{nextD, nextInd});
            }
        }
        return ans;
    }
}
