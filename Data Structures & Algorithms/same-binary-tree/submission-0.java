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
    public void inorder(TreeNode first, TreeNode second, Boolean[] eq)
    {
        if (first==null){
            if (second!=null) eq[0] = false;
            return;
        }
        if (second==null){
            if (first!=null) eq[0] = false;
            return;
        }
        inorder (first.left,second.left,eq);
        if (first.val != second.val){
            eq[0] = false;
            return;
        }
        inorder(first.right, second.right, eq);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p!=null && q==null) || (q!=null && p==null)) return false;
        Boolean[] eq = {true};
        inorder(p,q,eq);
        return eq[0];
    }
}
