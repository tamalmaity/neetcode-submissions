class Solution {
    int[][] dim = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pac = new boolean [m][n];
        boolean [][] atl = new boolean [m][n];

        for (int i=0;i<n;i++){
            dfs(0,i,heights,pac,m,n);
            dfs(m-1,i,heights,atl,m,n);
        }

        for (int i=0;i<m;i++){
            dfs(i,0,heights,pac,m,n);
            dfs(i,n-1,heights,atl,m,n);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (pac[i][j] && atl[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][]heights, boolean[][]visit, int m, int n){
        visit[i][j] = true;
        for (int itr=0;itr<4;itr++){
            int x = i+dim[itr][0];
            int y = j+dim[itr][1];
            if (x>=0 && y>=0 && x<m && y<n && !visit[x][y] && heights[x][y]>=heights[i][j])
                dfs(x,y,heights,visit,m,n);
        }
    }
}
