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
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
       int depth = findMaxDepth(root);
       sumDeepLeaves(root,1,depth);
       return sum;
    }
    public int findMaxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(findMaxDepth(root.left),findMaxDepth(root.right));
    }
    public void sumDeepLeaves(TreeNode root,int currHeight,int depth ) {
        if(root == null) {
            return;
        }
        sumDeepLeaves(root.left,currHeight+1,depth);
        if(currHeight == depth) {
            sum += root.val;
        }
        sumDeepLeaves(root.right,currHeight+1,depth);
    }
}