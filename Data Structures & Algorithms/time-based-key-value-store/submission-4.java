class TimeMap {
    public HashMap<String,List<Pair<Integer,String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)){
            List<Pair<Integer,String>> tmp = map.get(key);
            tmp.add(new Pair(timestamp, value));
            map.put(key,tmp);
        }
        else{
            List<Pair<Integer,String>> tmp = new ArrayList<>();
            tmp.add(new Pair(timestamp, value));
            map.put(key,tmp);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> val = map.getOrDefault(key, new ArrayList<>());
        int r = val.size()-1;
        int l = 0;
        String res = "";
        int ind=-1;
        while(l<=r){
            int m = l +(r-l)/2;
            int time = val.get(m).getTime();
            if (time<=timestamp){
                ind = m;
                l=m+1;
            }
            else r = m-1;
        }
        if(ind!=-1){
            Pair<Integer,String> ans = val.get(ind);
            res = ans.getStr();
        }
        return res;
    }

    private static class Pair<Integer,String>{
        private Integer a;
        private String b;
        
        public Pair(Integer a, String b){
            this.a = a;
            this.b = b;
        }

        public String getStr(){
            return b;
        }

        public Integer getTime(){
            return a;
        }
    }
}
