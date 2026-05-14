class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i=0;i<m;i++){
            if (board[i][0]=='O') dfs(i,0,m,n,board);
            if (board[i][n-1]=='O') dfs(i,n-1,m,n,board);
        }
        for (int i=0;i<n;i++){
            if (board[0][i]=='O') dfs(0,i,m,n,board);
            if (board[m-1][i]=='O') dfs(m-1,i,m,n,board);
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j]=='O') board[i][j] = 'X';
                else if (board[i][j]=='*') board[i][j] = 'O';
            }
        }
    }
    public void dfs(int i, int j, int m, int n, char[][]board){
        board[i][j] = '*';
        for (int[] dim : dir){
            int x = i+dim[0];
            int y = j+dim[1];
            if(x<0 || y<0 || x==m || y==n || board[x][y]!='O') continue;
            dfs(x,y,m,n,board);
        }
    }
}
