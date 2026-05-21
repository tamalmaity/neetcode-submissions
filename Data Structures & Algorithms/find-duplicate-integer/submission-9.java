class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for (int num : nums){
            arr[num]++;
        }
        for (int i=0;i<n+1;i++){
            if (arr[i]>1) return i;
        }
        return -1;
    }
}
