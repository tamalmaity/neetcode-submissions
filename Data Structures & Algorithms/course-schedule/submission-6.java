class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] tmp : prerequisites){
            int from = tmp[1];
            int to = tmp[0];
            adj.get(from).add(to);
        }

        for (int i=0;i<numCourses;i++){
            boolean[] seen = new boolean[numCourses];
            if (!dfs(i,seen,adj)) return false;
        }
        return true;
    }

    public boolean dfs(int i, boolean[]seen, List<List<Integer>> adj){
        seen[i] = true;
        List<Integer> tmp = adj.get(i);
        for (int edge : tmp){
            if (seen[edge]) return false;
            if(!dfs(edge,seen,adj)) return false;
        }
        seen[i] = false;
        adj.set(i, new ArrayList<>());
        return true;
    }
}
