class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer>arr = new ArrayList<Integer>();
        for (int stone:stones){
            arr.add(stone);
        }

        while (arr.size()>1){
            Collections.sort(arr);
            int index = arr.size();
            int max = arr.get(index-1);
            int next = arr.get(index-2);
            arr.remove(index-1);
            if (max==next) arr.remove(index-2);
            else arr.set(index-2,max-next);
        }

        if(arr.size()==0)return 0;
        else return arr.get(0);
        
    }
}
