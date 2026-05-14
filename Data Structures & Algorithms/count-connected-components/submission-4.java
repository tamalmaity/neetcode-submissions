class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = n;
        int [] parent = new int[n];
        for (int i=0;i<n;i++) parent[i] = i;
        for (int[]tmp:edges){
            int x = findParent(parent, tmp[0]);
            int y = findParent(parent, tmp[1]);

            if (x!=y){ // but I saw ane edge right now so connect it
                parent[x] = y;
                ans--;
            }
        }
        return ans;
    }

    private int findParent(int[] parent, int i){
        if (parent[i]!=i){
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }
}
