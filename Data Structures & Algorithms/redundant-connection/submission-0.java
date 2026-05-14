class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        for (int i=0;i<n+1;i++) par[i] = i;
        int[] ans = new int[2];
        for (int[]tmp:edges){
            int x = findPar(par,tmp[0]);
            int y = findPar(par,tmp[1]);
            if(x!=y){
                par[x] = y;
            }
            else{
                ans = tmp;
            }
        }
        return ans;
    }
    private int findPar(int[]par, int i){
        if (par[i]!=i){
            par[i] = findPar(par,par[i]);
        }
        return par[i];
    }
}
