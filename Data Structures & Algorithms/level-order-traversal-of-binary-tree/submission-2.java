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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> level = new ArrayList<>();
            while(sz!=0){
                TreeNode tmp = q.poll();
                level.add(tmp.val);
                if (tmp.left!=null) q.add(tmp.left);
                if (tmp.right!=null) q.add(tmp.right);
                sz--;
            }
            ans.add(level);
        }
        return ans;
    }

}
