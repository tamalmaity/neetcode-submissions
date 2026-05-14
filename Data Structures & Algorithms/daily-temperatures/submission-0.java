class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<int[]> st = new Stack<>(); //val,ind
        int sz = t.length;
        int[] ans = new int[sz];
        for (int i=0;i<sz;i++){
            if (st.size()==0 || t[i]<st.peek()[0]){
                st.push(new int[]{t[i],i});
            }
            else{
                while(st.size()>0 && st.peek()[0]<t[i]){
                    int[] top = st.pop();
                    ans[top[1]] = i-top[1];
                }
                st.push(new int[]{t[i],i});
            }
        }
        return ans;
    }
}
