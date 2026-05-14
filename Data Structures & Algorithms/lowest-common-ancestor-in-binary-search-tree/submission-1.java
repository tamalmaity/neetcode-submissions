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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode tmp = root;
        while (tmp.val!=p.val){
            if (tmp.val>p.val)
                tmp = tmp.left;
            else tmp = tmp.right;
            set.add(tmp);
        }
        tmp = root;
        TreeNode tmpans = null;
        while (tmp.val!=q.val){
            if (tmp.val>q.val) tmp = tmp.left;
            else tmp=tmp.right;
            if (set.contains(tmp)) tmpans = tmp;
        }
        return tmpans==null?root:tmpans;
    }
}
