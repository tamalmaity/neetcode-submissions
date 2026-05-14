class Solution {
    public HashMap<Character,List<Character>> map = new HashMap<>();
    public List<String> ans = new ArrayList<>();
    public void dfs(String digits, StringBuilder tmp, int i){
        if (i==digits.length()){
            ans.add(tmp.toString());
            return;
        }
        List<Character> list = map.get(digits.charAt(i));
        for (int x=0;x<list.size();x++){
            tmp.append((char)(list.get(x) + 32));
            dfs(digits,tmp,i+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        map.put('2',new ArrayList<>(Arrays.asList('A','B', 'C')));
    map.put('3',new ArrayList<>(Arrays.asList('D','E', 'F')));
    map.put('4',new ArrayList<>(Arrays.asList('G','H', 'I')));
    map.put('5',new ArrayList<>(Arrays.asList('J','K', 'L')));
    map.put('6',new ArrayList<>(Arrays.asList('M','N', 'O')));
    map.put('7',new ArrayList<>(Arrays.asList('P','Q', 'R', 'S')));
    map.put('8',new ArrayList<>(Arrays.asList('T','U', 'V')));
    map.put('9',new ArrayList<>(Arrays.asList('W','X', 'Y', 'Z')));
    if (digits.length()==0) return new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        dfs(digits, tmp, 0);
        return ans;
    }
}
