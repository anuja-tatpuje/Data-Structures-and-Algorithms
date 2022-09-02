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
    List<Double> average = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        double sum = 0;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int s = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            s = size;
            sum = 0.0;
            while(size-->0) {
                TreeNode top = que.removeFirst();
                
                sum += top.val;
                
                if(top.left != null) {
                    que.addLast(top.left);
                } if(top.right != null) {
                    que.addLast(top.right);
                }
            }
            average.add(sum/s);
        }
        
        return average;
    }
}