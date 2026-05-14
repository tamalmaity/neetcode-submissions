class Solution {
    public int ans = 0;
    public int[][] dim = {{1,0}, {0,1}, {-1,0}, {0,-1}}; 
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][]seen = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) seen[i][j] = false;
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1' && !seen[i][j]){
                    ans++;
                    seen[i][j] = true;
                    visit(seen, grid, i ,j, m ,n);
                }
            }
        }
        return ans;
    }

    public void visit (boolean[][] seen, char[][] grid, int i, int j, int m, int n){

        for (int itr = 0; itr<4;itr++){
            int x = i+dim[itr][0];
            int y = j+dim[itr][1];
            if (x<0 || y<0 || x==m || y==n) continue;
            if (grid[x][y]=='1' && !seen[x][y]){
                seen[x][y] = true;
                visit (seen, grid, x, y, m, n);
            }
        }
    }
}
