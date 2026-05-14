class Solution {
    public int singleNumber(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
       for (int num:nums){
           if (!map.containsKey(num)) map.put(num,1);
           else map.put(num,2); 
       } 
       for (int key:map.keySet()){
        if (map.get(key)==1) return key;
       }
       return -1;
    }
}
