public class Node{
    int key;
    int val;
    Node left;
    Node right;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }

    public void delete(){
        Node lft = this.left;
        Node rght = this.right;
        lft.right = rght;
        rght.left = lft;
        return;
    }
}

class LRUCache {
    int cap;
    Node start, end;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        Node tmp1 = new Node (-1,-1);
        Node tmp2 = new Node (-1,-1);
        tmp1.right = tmp2;
        tmp2.left = tmp1;
        start = tmp1;
        end = tmp2;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node tmp = map.get(key);
            tmp.delete();
            tmp.left = start;
            tmp.right = start.right;
            start.right.left = tmp;
            start.right = tmp;
            return tmp.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node tmp = map.get(key);
            tmp.delete();
            tmp.left = start;
            tmp.right = start.right;
            start.right.left = tmp;
            start.right = tmp;
            tmp.val = value;
            return;
        }
        else if (map.size()==cap){
            int keyRemove = end.left.key;
            end.left.delete();
            map.remove(keyRemove);
        }
        Node newNode = new Node(key, value);
        newNode.left = start;
        newNode.right = start.right;
        start.right.left = newNode;
        start.right = newNode;
        map.put(key, newNode);
        return;
    }
}
