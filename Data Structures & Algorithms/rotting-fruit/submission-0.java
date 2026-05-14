class Solution {
    int[][] dim = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;

        Queue<int[]>q = new LinkedList<>();
        int level = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==2){
                    q.add(new int[]{i,j});
                    level++;
                }
                else if (grid[i][j] == 1) fresh++;
            }
        }

        int step = 0;
        while (fresh>0 && q.size()!=0){
            int size = q.size();
            for (int i=0;i<size;i++){
                int[] tmp = q.poll();
                for (int[] dir : dim){
                    int x = tmp[0] + dir[0];
                    int y = tmp[1] + dir[1];

                    if (x<0||y<0||x==m||y==n||grid[x][y]!=1) continue;
                    else{
                        grid[x][y] = 2;
                        q.add(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            step++;
        }
        return (fresh>0)?-1:step;
    }
}
