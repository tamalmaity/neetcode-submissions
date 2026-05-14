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
    public boolean compare(TreeNode root, TreeNode subRoot){
        if (root==null && subRoot==null) return true;
        if ((root==null && subRoot!=null) || (root!=null && subRoot==null) || (root.val!=subRoot.val))
        return false;
        if (root.val==subRoot.val)
        return (compare(root.left,subRoot.left) && compare(root.right,subRoot.right)); 
        else return false;  
    }
    public void inorder(TreeNode root, TreeNode subRoot, Boolean[] stFound){
        if (root==null || stFound[0]) return;
        inorder(root.left, subRoot, stFound);
        if (compare(root,subRoot)){
            stFound[0] = true;
            return;
        }
        inorder(root.right,subRoot,stFound);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Boolean stFound[] = {false};
        inorder(root, subRoot, stFound);
        return stFound[0];  
    }
}
