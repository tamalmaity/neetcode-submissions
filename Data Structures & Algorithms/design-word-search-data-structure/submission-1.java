class TrieNode{
    TrieNode[] child;
    boolean end;

    public TrieNode(){
        this.child = new TrieNode[26];
        this.end = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (Character ch : word.toCharArray()){
            int i = ch-'a';
            if (curr.child[i]== null) curr.child[i] = new TrieNode();
            curr = curr.child[i];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return helper(root, word);
    }

    public boolean helper(TrieNode curr, String word){
        if (word.length()==1){
            if (word.charAt(0)=='.'){
                for (int i=0;i<26;i++){
                    if (curr.child[i]!=null && curr.child[i].end) return true;
                }
                return false;

            }
                
            int ind = word.charAt(0)-'a';
            if (curr.child[ind]!=null && curr.child[ind].end) return true;
            else return false;
        }
        else{
            if (word.charAt(0)=='.'){
                boolean ans = false;
                for (int i=0;i<26;i++){
                    if (curr.child[i]!=null)
                    ans = ans || helper(curr.child[i], word.substring(1,word.length()));
                }
                return ans;
            }
            else{
                int ind = word.charAt(0)-'a';
                if (curr.child[ind]==null) return false;
                else return helper(curr.child[ind], word.substring(1,word.length()));
            }
        }
    }
}
