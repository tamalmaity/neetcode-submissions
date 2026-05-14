class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] tr : triplets){
            if (tr[0]>target[0] || tr[1]>target[1] || tr[2]>target[2])
                continue;
            
            if (tr[0]==target[0]) found[0] = true;
            if (tr[1]==target[1]) found[1] = true;
            if (tr[2]==target[2]) found[2] = true;
        }
        return found[0] && found[1] && found[2];
    }
}
