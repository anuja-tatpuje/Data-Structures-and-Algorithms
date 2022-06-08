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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lar = new ArrayList<>();
        
        if(root == null) return lar;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
         
        while(que.size()>0) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            while(size-->0) {
                TreeNode node = que.removeFirst();
                max = Math.max(max,node.val);
                
                if(node.left != null) {
                    que.addLast(node.left);
                } if(node.right != null) {
                    que.addLast(node.right);
                }
            }
            lar.add(max);
        }
        
        return lar;
    }
}