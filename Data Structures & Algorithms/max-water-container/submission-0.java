class Solution {
    public int maxArea(int[] heights) {
        int water = 0;
        int l=0,r=heights.length-1;
        while(l<r){
            water = Math.max(water, Math.min(heights[l],heights[r]) * (r-l));
            if (heights[l]<heights[r])l++;
            else r--;
        }
        return water;
    }
}
