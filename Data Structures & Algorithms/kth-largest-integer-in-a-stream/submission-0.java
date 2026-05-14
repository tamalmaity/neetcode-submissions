class KthLargest {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int K;
    public KthLargest(int k, int[] nums) {
        for (int i=0;i<nums.length;i++) arr.add(nums[i]);
        K = k;
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size()-K);
    }
}
