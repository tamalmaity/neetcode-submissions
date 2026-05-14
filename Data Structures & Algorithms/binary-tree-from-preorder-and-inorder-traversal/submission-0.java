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
    public int preInd = 0;
    public HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode dfs(int[]preorder, int[]inorder, int l, int r){
        if (l>r) return null;
        int mid = map.get(preorder[preInd]);
        TreeNode newNode = new TreeNode(preorder[preInd++]);
        newNode.left = dfs(preorder,inorder,l,mid-1);
        newNode.right = dfs(preorder,inorder,mid+1,r);
        return newNode;
    }
}
