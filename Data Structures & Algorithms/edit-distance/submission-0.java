class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i, int j){
        if (j>=word2.length()){
            if ((word1.length()-i)>=0) return (word1.length()-i);
        }
        if (i>=word1.length()){
            if ((word2.length()-j)>=0) return (word2.length()-j);
        }
        
        if (word1.charAt(i)==word2.charAt(j)) return dfs(word1, word2, i+1, j+1);
        int x = dfs(word1,word2,i,j+1)+1;
        int y = dfs(word1,word2,i+1,j)+1;
        int z = dfs(word1,word2,i+1,j+1)+1;
        return Math.min(x,Math.min(y,z));
    }
}
