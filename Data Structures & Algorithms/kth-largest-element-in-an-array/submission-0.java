class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b) -> (b-a));
        for (int num:nums){
            pq.offer(num);
        }

        int i = 1;
        while (i!=k){
            pq.poll();
            i++;
        }
        return pq.peek();

    }
}
