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
    public int findHeight(TreeNode node)
    {
        if (node == null) return 0;
        return 1+ Math.max(findHeight(node.left), findHeight(node.right));
    }
    public void inorder (TreeNode node, ArrayList<Boolean> balanced)
    {
        if (node == null) return;
        inorder(node.left, balanced);
        int leftHt = findHeight(node.left);
        int rightHt = findHeight(node.right);
        int diffHt = leftHt - rightHt;
        if (diffHt >= -1 && diffHt <= 1) balanced.add(true);
        else balanced.add(false);
        inorder(node.right, balanced);
    }
    public Boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        ArrayList <Boolean> balanced = new ArrayList<Boolean>();
        inorder(root, balanced);
        for (Boolean item : balanced){
            if (!item) return false;
        }
        return true;
    }
}
