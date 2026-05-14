/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        else return dfs(node);
    }

    public Node dfs(Node node){
        if (map.containsKey(node)) return map.get(node);

        Node tmp = new Node (node.val, new ArrayList<>());
        map.put(node, tmp);

        List<Node> neigh = node.neighbors;
        for (int i=0;i<neigh.size();i++){
            tmp.neighbors.add(dfs(neigh.get(i)));
        }
        return tmp;
    }
}