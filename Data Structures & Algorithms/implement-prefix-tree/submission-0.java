class TrieNode{
    TrieNode[] child;
    boolean end;
    public TrieNode(){
        this.child = new TrieNode[26];
        this.end = false;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        char[] arr = word.toCharArray();
        int i = 0;
        while(i<arr.length){
            if (curr.child[arr[i]-'a']==null) curr.child[arr[i]-'a'] = new TrieNode();
            curr = curr.child[arr[i]-'a'];
            i++;
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        char[] arr = word.toCharArray();
        int i = 0;
        while (i<arr.length){
            if (curr.child[arr[i]-'a']==null) return false;
            else curr = curr.child[arr[i]-'a'];
            i++;
        }
        if (curr.end!=true) return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] arr = prefix.toCharArray();
        int i = 0;
        while (i<arr.length){
            if (curr.child[arr[i]-'a']==null) return false;
            else curr = curr.child[arr[i]-'a'];
            i++;
        }
        return true;
    }
}
