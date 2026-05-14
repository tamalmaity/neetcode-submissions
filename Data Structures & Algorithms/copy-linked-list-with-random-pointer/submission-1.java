/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node ans = new Node(head.val);
        map.put(head,ans);
        Node tmp = ans, headOrg = head;
        while (head.next!=null){
            Node newNode = new Node(head.next.val);
            tmp.next = newNode;
            map.put(head.next,newNode);
            head = head.next;
            tmp = tmp.next;
        }
        while (headOrg != null){
            Node curr = map.get(headOrg);
            Node randNode = map.get(headOrg.random);
            curr.random = randNode;
            headOrg = headOrg.next;
        }
        return ans;
}
}
