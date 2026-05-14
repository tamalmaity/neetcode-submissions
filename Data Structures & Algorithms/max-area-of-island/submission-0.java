class Solution {
    public int ans = 0;
    public int[][] dim = {{0,1},{1,0},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean [m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) seen[i][j] = false;
        }
        int retSize = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 1 && !seen[i][j]){
                    seen[i][j] = true;
                    visit(grid, seen, i, j, m, n);
                    ans++;
                    retSize = Math.max(ans, retSize);
                    ans = 0;
                }
            }
        }
        return retSize;
            
    }

    public void visit (int[][]grid, boolean[][] seen, int i, int j, int m, int n){
        for (int itr = 0; itr<4;itr++){
            int x = i+dim[itr][0];
            int y = j+dim[itr][1];
            if (x<0 || y<0 || x==m || y==n) continue;
            if (grid[x][y] == 1 && !seen[x][y]){
                seen[x][y] = true;
                ans++;
                visit(grid, seen, x, y, m, n);
            }
    }
    return;
    }
}
