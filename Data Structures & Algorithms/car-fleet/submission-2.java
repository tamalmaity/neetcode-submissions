class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> car = new ArrayList<>();

        for (int i=0;i<position.length;i++){
            car.add(new int[]{position[i],speed[i]});
        }

        Collections.sort(car, (a,b)->Integer.compare(b[0],a[0]));
        int ans = 1;
        double prevHigh = (double)(target-car.get(0)[0])/(car.get(0)[1]);;
        for (int i =1; i<car.size();i++){
            double t1 = (double)(target-car.get(i-1)[0])/(car.get(i-1)[1]);
            double t2 = (double)(target-car.get(i)[0])/(car.get(i)[1]);
            if(prevHigh<t2){
                ans++;
                prevHigh = t2;
            }
            else{
                prevHigh = Math.max(prevHigh, t1);
                continue;
            }
        }
        return ans;
    }
}