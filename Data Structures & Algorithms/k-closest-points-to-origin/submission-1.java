class Distance{
    int dist;
    int x;
    int y;

    public Distance(int x, int y){
        this.x = x;
        this.y = y;
        this.dist = (x*x) + (y*y);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        for (int i=0;i<points.length;i++) {
            Distance d = new Distance (points[i][0], points[i][1]);
            pq.offer(d);
        }
        int [][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Distance d = pq.poll();
            ans[i][0] = d.x;
            ans[i][1] = d.y;
        }
        return ans;
    }
}
