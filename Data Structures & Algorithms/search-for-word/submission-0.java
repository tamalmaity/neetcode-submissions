class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int j=0;j<board.length;j++){
            for (int k=0;k<board[0].length;k++){
                if (word.charAt(0)==board[j][k]){
                    if (helper(board,word,j,k,0,seen)) return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][]board, String word, int x, int y, int i, boolean[][] seen){
        if(i==word.length()) return true;
        if (x<0 || y<0 || x>=board.length || y>=board[0].length) return false;
        if(seen[x][y] || word.charAt(i)!=board[x][y]) return false;

        seen[x][y] = true;
        if (
            helper(board,word, x+1, y, i+1, seen) ||
            helper(board,word, x, y+1, i+1, seen) ||
            helper(board,word, x-1, y, i+1, seen) ||
            helper(board,word, x, y-1, i+1, seen)
        )
        return true;
        seen[x][y] = false;
        
        return false;
        
    }
}
