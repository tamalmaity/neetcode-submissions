/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preInd = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int st, int end){
        if (st>end) return null;
        int root = preorder[preInd++];
        int ind = mp.get(root);
        TreeNode ans = new TreeNode(root);
        ans.left = helper(preorder, inorder, st, ind-1);
        ans.right = helper(preorder, inorder, ind+1, end);
        return ans;
    }
}
