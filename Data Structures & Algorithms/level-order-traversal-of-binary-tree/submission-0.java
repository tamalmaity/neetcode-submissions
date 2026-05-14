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
    public void preorder (TreeNode node, int height, ArrayList<ArrayList<Integer>> ans){
        if (node==null) return;
        if (ans.size()<(height+1)){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            ans.add(tmp);
        }
        else{
            ans.get(height).add(node.val);
        }
        preorder(node.left,height+1,ans);
        preorder(node.right,height+1,ans);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        preorder(root,0,ans);
        return new ArrayList<>(ans);
    }
}
