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
    public int leafDist(TreeNode node){
        if (node == null) return 0;
        return 1 + Math.max(leafDist(node.left), leafDist(node.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int rootMax = leafDist(root.left) + leafDist(root.right);
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), rootMax);
    }
}
