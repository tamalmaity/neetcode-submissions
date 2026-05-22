class LRUCache {
    int N;
    LinkedHashMap<Integer, Integer> mp;
    public LRUCache(int capacity) {
        N = capacity;
        mp = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (!mp.containsKey(key)) return -1;
        else{
            int ans = mp.get(key);
            mp.remove(key);
            mp.put(key, ans);
            return ans;
        }  
    }
    
    public void put(int key, int value) {
        if (mp.containsKey(key)){
            mp.remove(key);
        }
        else{
            int n = mp.size();
            if (n>=N){
                for (int remKey : mp.keySet()){
                    mp.remove(remKey);
                    break;
                }
            }
        }
        mp.put(key,value);
    }
}
