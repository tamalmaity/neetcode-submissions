class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int i=0, j=size-1;
        int sum = numbers[i] + numbers[j];
        while (i<j && sum != target){
            if (sum<target){
                sum-= numbers[i];
                sum+= numbers[++i];
            }
            else{
                sum-= numbers[j];
                sum+= numbers[--j];
            }
        }
        return new int[]{i+1,j+1};
    }
}
