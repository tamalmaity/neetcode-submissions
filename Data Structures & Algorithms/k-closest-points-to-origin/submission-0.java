class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        for (int i=0;i<points.length;i++){
            int dist = ((points[i][0]) * (points[i][0]) + (points[i][1]) * (points[i][1]));
            ArrayList tmp = map.getOrDefault(dist,new ArrayList<>());
            tmp.add(i);
            map.put(dist,tmp);
        }
        
        List<Integer> uniqueDist = new ArrayList<>();
        for (int keys : map.keySet()){
            uniqueDist.add(keys);
        }
        Collections.sort(uniqueDist);

        int[][] ans = new int[k][2];
        int seen = 0;
        for (int i=0;i<uniqueDist.size();i++){
            ArrayList<Integer>tmp = map.get(uniqueDist.get(i));
            for (int j=0;j<tmp.size();j++){
                int ind = tmp.get(j);
                ans[seen][0] = points[ind][0];
                ans[seen][1] = points[ind][1];
                seen++;
                if (seen == k) break;
            }
            if (seen==k) break;
        }
        return ans;
    }
}
