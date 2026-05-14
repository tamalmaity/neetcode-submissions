class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if((n1+n2)!=n3) return false;
        else return dfs(0,0,0,n1,n2,n3,s1,s2,s3);
    }
    private boolean dfs(int i, int j, int k, int n1, int n2, int n3, String s1, String s2, String s3){
        if (k==n3) return true;
        if (i==n1){
            for (int x=j;x<n2;x++){
                
                if (s2.charAt(x)!=s3.charAt(k++)) return false;
            }
            return true;
        }
        if (j==n2){
            for (int x=i;x<n1;x++){
                if (s1.charAt(x)!=s3.charAt(k++)) return false;
            }
            return true;
        }
        boolean a = false;
        boolean b = false;
        if (s3.charAt(k)==s1.charAt(i)) a = dfs(i+1,j,k+1,n1,n2,n3,s1,s2,s3);
        if (s3.charAt(k)==s2.charAt(j)) b = dfs(i,j+1,k+1,n1,n2,n3,s1,s2,s3);
        if (!a && !b) return false;
        return true;
    }
}
