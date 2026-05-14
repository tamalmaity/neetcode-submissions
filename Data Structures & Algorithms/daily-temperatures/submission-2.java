class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> st = new Stack<>();
        int[] ans = new int[n];
        st.push(new int[] {temperatures[n-1], n-1});
        for (int i=n-2;i>=0;i--){
            while (!st.isEmpty() && st.peek()[0]<=temperatures[i]){
                st.pop();
            }
            if (st.isEmpty()) ans[i] = 0;
            else{
                ans[i] = st.peek()[1] - i;
            }
            st.push(new int[]{temperatures[i],i});
        }
        return ans;
    }
}
