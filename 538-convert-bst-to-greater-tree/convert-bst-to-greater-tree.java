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
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        inorder(root,ans);
return root;                                                                 
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> ans) {
        if (root == null) return;
        inorder(root.right, ans);
        sum += root.val;
        root.val = sum;
        inorder(root.left, ans);

    }
}