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
    public int ans = 0;
    public void traverse(TreeNode node, int maxm){
        if (node == null) return;
        if (node.val>=maxm){
            ans++;
            maxm = node.val;
        }
        traverse(node.left, maxm);
        traverse(node.right,maxm);
    }

    public int goodNodes(TreeNode root) {
        traverse(root,-101);
        return ans;
    }
}
