class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mp = new HashMap<>();
        for (List<String> t : tickets){
            mp.computeIfAbsent(t.get(0), k->new PriorityQueue<String>()).add(t.get(1));
        }
        List<String> ans = new ArrayList<>();
        dfs(ans, mp, "JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(List<String> ans, Map<String, PriorityQueue<String>> mp, String node){
        PriorityQueue<String> pq = mp.getOrDefault(node, new PriorityQueue<>());
        while(!pq.isEmpty()){
            String neigh = pq.poll();
            dfs(ans, mp, neigh);
        }
        ans.add(node);
    }
}
