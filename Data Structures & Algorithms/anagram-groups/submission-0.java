class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> sortedStr = new ArrayList<String>();
        for (String s:strs){
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            sortedStr.add(new String(characters));
        }
        HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
        int count = 0;
        for (String s:sortedStr){
            if (!map.containsKey(s)){
                ArrayList<Integer> lst = new ArrayList<Integer>();
                lst.add(count++);
                map.put(s,lst);
            }
            else{
                ArrayList<Integer> val = map.get(s);
                val.add(count++);
                map.put(s,val);
            } 
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        for (String k:map.keySet()){
            List<String> sorted = new ArrayList<String>();
            List<Integer> vals = map.get(k);
            for (Integer val: vals){
                sorted.add(strs[val]);
            }
            ans.add(sorted);
        }
        return ans;
    }
}
