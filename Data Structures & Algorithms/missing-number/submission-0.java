class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum = (size * (size+1))/2;
        int actSum = 0;
        for (int i:nums) actSum+= i;
        return (sum-actSum);
    }
}
