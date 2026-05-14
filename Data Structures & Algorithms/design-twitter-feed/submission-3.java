class tweet{
    int time;
    int tweetid;

    public tweet(int time, int tweetid){
        this.time = time;
        this.tweetid = tweetid;
    }
}

class Twitter {
    int time = 0;
    HashMap<Integer, List<int[]>> map;
    HashMap<Integer,List<Integer>> follow;
    
    public Twitter() {
        map = new HashMap<>();
        follow = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        List<int[]>tmp = new ArrayList<>();
        if (map.containsKey(userId)){
            tmp = map.get(userId);
        }
        tmp.add(new int[] {time,tweetId});
        map.put(userId,tmp);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<tweet> pq = new PriorityQueue<>((a,b)->(b.time-a.time));
        List<Integer> followers = follow.getOrDefault(userId, new ArrayList<>());
        List<Integer> copy = new ArrayList<>(followers);
        copy.add(userId);
        
        for (int i=0;i<copy.size();i++){
            List<int[]> tmp = map.get(copy.get(i));
            if (tmp == null) break;
            for (int j=0;j<tmp.size();j++){
                int[] tmp1 = tmp.get(j);
                pq.add(new tweet(tmp1[0],tmp1[1]));
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size()<10){
            ans.add(pq.poll().tweetid);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        List<Integer>tmp = new ArrayList<>();
        if(follow.containsKey(followerId)){
            tmp = follow.get(followerId);
        }
        if (tmp.contains(followeeId)) return;
        tmp.add(followeeId);
        follow.put(followerId,tmp);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) return;
        List<Integer>tmp = follow.get(followerId);
        tmp.remove(Integer.valueOf(followeeId));
        follow.put(followerId,tmp);
    }
}
