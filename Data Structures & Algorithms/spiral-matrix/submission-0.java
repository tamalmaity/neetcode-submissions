class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return ans;

    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
        // → move right
        for (int j = left; j <= right; j++)
            ans.add(matrix[top][j]);
        top++;

        // ↓ move down
        for (int i = top; i <= bottom; i++)
            ans.add(matrix[i][right]);
        right--;

        // ← move left (check before to avoid double-counting)
        if (top <= bottom) {
            for (int j = right; j >= left; j--)
                ans.add(matrix[bottom][j]);
            bottom--;
        }

        // ↑ move up (check before)
        if (left <= right) {
            for (int i = bottom; i >= top; i--)
                ans.add(matrix[i][left]);
            left++;
        }
    }

    return ans;
}}