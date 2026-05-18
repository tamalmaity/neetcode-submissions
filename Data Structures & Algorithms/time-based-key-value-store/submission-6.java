public class Pair{
    private Integer time;
    private String value;
    Pair(Integer time, String value){
        this.time = time;
        this.value = value;
    }
    public Integer getKey(){
        return time;
    }
    public String getValue(){
        return value;
    }
}
class TimeMap {
    Map<String, List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k->new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key) || mp.get(key).get(0).getKey()>timestamp) return "";
        List<Pair> arr = mp.get(key);
        int l = 0, r = arr.size()-1, ans = l;
        while(l<=r){
            int m = l+ (r-l)/2;
            if (arr.get(m).getKey()<=timestamp){
                ans = m;
                l=m+1;
            }
            else r = m-1;
        }
        return arr.get(ans).getValue();
    }
}
