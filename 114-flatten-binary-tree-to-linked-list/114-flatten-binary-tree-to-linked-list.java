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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        flattenTree(root);
    }
    
    public void flattenTree(TreeNode root) {
        if(root == null)  return;
        
        if(root.left == null && root.right == null)
            return;
        
        //go to left recursively
        flattenTree(root.left);
        
        //if root.left is available then get swipe the values from left to right
        if(root.left != null) {
            
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            //traverse in right direction until you get end of the recently attached 
            //left flatten tree
            TreeNode curr = root.right;

            while(curr.right != null) {
                curr = curr.right;
            }
            
            //then attach stored right subtree
            curr.right = temp;
        }
        
        flattenTree(root.right);
    }
}