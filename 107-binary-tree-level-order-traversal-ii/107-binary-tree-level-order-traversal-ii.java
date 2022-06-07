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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return res;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        que.addFirst(root);
        que.addLast(null);
        
        while(que.size()>0) {
           TreeNode node = que.removeFirst();
            
           if(node != null) {
               level.add(node.val);
               
               if(node.left != null) {
                   que.addLast(node.left);
               } if(node.right != null) {
                   que.addLast(node.right);
               }
               
           }  else if(que.size()>0){
               res.add(0,level);
               level = new ArrayList<>();
               que.addLast(null);
           }
        }
        res.add(0,level);
        return res;
    }
}