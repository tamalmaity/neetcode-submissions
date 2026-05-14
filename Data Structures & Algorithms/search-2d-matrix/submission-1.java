class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row-1;
        int m = l;
        while(l<=r){
            m = l+(r-l)/2;
            if(matrix[m][0]<target)l=m+1;
            else if (matrix[m][0]>target)r=m-1;
            else return true;
        }
        int myRow = m;
        if(matrix[m][0]<target)myRow = m;
        else if (m>0) myRow = m-1;
        l=0;
        r=col-1;
        while(l<=r){
            m = l+(r-l)/2;
            if(matrix[myRow][m]<target)l=m+1;
            else if(matrix[myRow][m]>target)r=m-1;
            else return true;
        }
        return false;
    }
}
