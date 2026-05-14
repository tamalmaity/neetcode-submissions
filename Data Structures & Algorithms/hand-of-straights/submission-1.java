class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n%groupSize != 0) return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x:hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        for (int i=0;i<n;i++){
            if (map.get(hand[i])==0) continue;
            int start = hand[i];
            int count = 0;
            while (count<groupSize){
                if(!map.containsKey(start) || map.get(start)==0) return false;
                else map.put(start, map.get(start)-1);
                
                System.out.println(count + " "+ start);
                count++;
                start++;
                
            }
        }
        return true;

    }
}
