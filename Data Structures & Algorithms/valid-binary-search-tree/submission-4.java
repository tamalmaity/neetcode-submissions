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
    public boolean workerValBST(TreeNode root, int minm, int maxm){
        if (root== null) return true;
        if (root.val<=minm || root.val>=maxm) return false;
        boolean lft = workerValBST(root.left, minm, root.val);
        boolean rght = workerValBST(root.right, root.val, maxm);
        return lft && rght;
    }
    public boolean isValidBST(TreeNode root) {
        int minm = Integer.MIN_VALUE;
        int maxm = Integer.MAX_VALUE;
        return workerValBST(root, minm, maxm);
    }
}
