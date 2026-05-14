class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;

        boolean[] safe = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<m;i++){
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            adj.get(from).add(to);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            boolean[] seen = new boolean[numCourses];
            if (!safe[i]){
                if (!dfs(i, seen, safe, adj, ans)) return new int[0];
            }
        }
        int[] retAns = new int[numCourses];
        for (int i=0;i<numCourses;i++) retAns[i] = ans.get(i);
        return retAns;
    }

    public boolean dfs(int i, boolean[]seen, boolean[]safe, List<List<Integer>>adj, List<Integer> ans){
        seen[i] = true;
        List<Integer>edge = adj.get(i);
        for (Integer x:edge){
            if (safe[x]) continue;
            if (seen[x]) return false;
            if (!dfs(x,seen,safe,adj, ans)) return false;
        }
        seen[i] = false;
        safe[i] = true;
        ans.add(i);
        return true;
    }
}
