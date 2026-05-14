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
    public ArrayList<Integer> ans;
    public void preorder(TreeNode root, int height){
        if(root==null) return;
        if (ans.size()<(height+1)) ans.add(root.val);
        else{
            ans.set(height,root.val);
        }
        preorder(root.left,height+1);
        preorder(root.right,height+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        preorder (root, 0);
        return ans;
    }
}
