class Solution {
    int inf = Integer.MAX_VALUE;
    int[][] dim = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==0) q.add(new int[]{i,j});
            }
        }
        while (q.size()!=0){
            int[] tmp = q.poll();
            for (int i=0;i<4;i++){
                int x = tmp[0] + dim[i][0];
                int y = tmp[1] + dim[i][1];
                if (x<0 || y<0 || x==m || y==n ||
                    grid[x][y]!=inf) continue;
                else grid[x][y] = grid[tmp[0]][tmp[1]] + 1;
                q.add(new int[]{x,y});
            }
        }
    }
}
