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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root,0);
        return ans;
    }
    public void rightSideView(TreeNode root,int level) {
        if(root == null) return;
        if(ans.size() == level) {
            ans.add(root.val);
        }
        rightSideView(root.right,level+1);
        rightSideView(root.left,level+1);
    }
}