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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        tree2StrHelper(root);
        return sb.toString();
    }
    public void tree2StrHelper(TreeNode root) {
        if(root == null) return;
            sb.append(root.val);
            if(root.left != null) {
                sb.append('(');
                tree2StrHelper(root.left);
                sb.append(')');
            } if(root.right != null) {
                 if (root.left == null) {
                    sb.append("()");
                }
               sb.append('(');
                tree2StrHelper(root.right);
                sb.append(')');
            }
        }
}