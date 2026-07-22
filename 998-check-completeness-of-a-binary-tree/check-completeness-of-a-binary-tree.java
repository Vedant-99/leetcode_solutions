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
    static int size;
    public boolean isCompleteTree(TreeNode root) {
        size = sizeOf(root);
        return isCBT(root,1);
    }
    public boolean isCBT(TreeNode root,int idx){
        if(root==null) return true;
        if(idx>size) return false;
        return isCBT(root.left,2*idx) && isCBT(root.right,2*idx+1);
    }
    public int sizeOf(TreeNode root){
        if(root==null) return 0;
        return 1+sizeOf(root.left)+sizeOf(root.right);
    }
}
