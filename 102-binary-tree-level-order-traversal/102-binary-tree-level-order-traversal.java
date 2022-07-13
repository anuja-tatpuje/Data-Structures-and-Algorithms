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
    List<List<Integer>> level = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
         if(root == null)
            return level;
        levelOrderHelper(root);
        return level;
    }
    public void levelOrderHelper(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.addLast(root);
        
        while(queue.size() > 0) {
            int size = queue.size();
            List<Integer> oneLevel = new ArrayList<>();
            while(size-- > 0) {
                TreeNode n = queue.removeFirst();
                
                oneLevel.add(n.val);
                
                if(n.left != null) {
                    queue.addLast(n.left);
                }
                if(n.right != null) {
                    queue.addLast(n.right);
                }
            }
            
            level.add(oneLevel);
        }
    }
}