class Solution {
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (int[] tmp : edges){
            adj.get(tmp[0]).add(tmp[1]);
            adj.get(tmp[1]).add(tmp[0]);
        }
        boolean[] seen = new boolean[n];
        if (!dfs(0,-1,seen,adj)) return false;
        for (int i=0;i<n;i++){
            if (!seen[i]) return false;
        }
        return true;
    }

    public boolean dfs(int i, int par, boolean[]seen, List<List<Integer>> adj){
        seen[i] = true;
        List<Integer>tmp = adj.get(i);
        boolean ans = true;
        for (int x :tmp){
            if (seen[x]){
                if (x==par) continue;
                else return false;
            }
            ans = ans && dfs(x,i,seen,adj);
        }
        return ans;
    }
}
