class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int i = 0;
        for (int[] p : points){
            int dist = p[0]*p[0] + p[1]*p[1];
            pq.add(new int[]{dist, i++});
            if (pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        i = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int[] point = points[tmp[1]];
            ans[i++] = point;
        }
        return ans;
    }
}
