class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totGas = Arrays.stream(gas).sum();
        int totCost = Arrays.stream(cost).sum();
        if (totGas<totCost) return -1;
        int total = 0, ans=0;
        boolean start = false;
        for (int i=0;i<n;i++){
            while(i<n){
                total += (gas[i]-cost[i]);
                if (total<0){
                    total = 0;
                    start = false;
                    break;
                }
                if (!start){
                    ans = i;
                    start = true;
                }
                i++;
            }
        }
        return ans;
    }
}