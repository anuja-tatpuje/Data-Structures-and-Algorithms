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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size()>0) {
            int size = que.size();
            while(size-->0) {
                TreeNode node = que.removeFirst();
                
                if(node.left == null && node.right == null){
                    return depth;
                }
                
                if(node.left != null) {
                    que.addLast(node.left);
                } if(node.right != null) {
                    que.addLast(node.right);
                }
            }
            depth++;
        }
        
        return depth;
    }
}