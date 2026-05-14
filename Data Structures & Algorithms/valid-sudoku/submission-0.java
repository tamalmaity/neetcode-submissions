class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<String>> row = new ArrayList<HashSet<String>>();
        ArrayList<HashSet<String>> col = new ArrayList<HashSet<String>>();
        ArrayList<HashSet<String>> sq = new ArrayList<HashSet<String>>();

        for (int i=0;i<9;i++){
            HashSet<String> hsr = new HashSet<String>();
            row.add(hsr);
            HashSet<String> hsc = new HashSet<String>();
            col.add(hsc);
            HashSet<String> hss = new HashSet<String>();
            sq.add(hss);
        }

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.') continue;
                HashSet<String>hsr = row.get(i);
                HashSet<String>hsc = col.get(j);
                int sqInd = ((i/3)*3) + (j/3);
                HashSet<String>hss = sq.get(sqInd);
                String str = Character.toString(board[i][j]);
                if (!hsr.add(str)) return false;
                if (!hsc.add(str)) return false;
                if (!hss.add(str)) return false;
                
                row.set(i,hsr);
                col.set(j,hsc);
                sq.set(sqInd,hss);
            }
        }
        return true;
    }
}
