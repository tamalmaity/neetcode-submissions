class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y) return false; // cycle detected
            parent[x] = y; // union
        }

        return true; // connected + acyclic
    }

    private int find(int[] parent, int x) {
        // path compression
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
