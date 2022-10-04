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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root,targetSum);
    }
    public boolean hasPathSumHelper(TreeNode root,int tar) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == tar) {
            return true;
        } else {
           boolean left =  hasPathSumHelper(root.left,tar-root.val);
           boolean right =  hasPathSumHelper(root.right,tar-root.val);
            
            return left || right;
        } 
    }
}