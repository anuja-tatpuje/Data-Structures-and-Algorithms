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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        TreeNode rootNode = root;
        return addOneRow(root,val,depth,1);
    }
    public TreeNode addOneRow(TreeNode root,int val,int depth,int currDepth) {
        if(root == null) {
            return null;
        }
        if(currDepth+1 == depth) {
            TreeNode currLeftNode = root.left;
            TreeNode currRightNode = root.right;
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);
            root.left = leftNode;
            root.right = rightNode;
            
            leftNode.left = currLeftNode;
            rightNode.right = currRightNode;
            
            return root;
        } else {
            addOneRow(root.left,val,depth,currDepth+1);
            addOneRow(root.right,val,depth,currDepth+1);
        }
        
        return root;
    }
}