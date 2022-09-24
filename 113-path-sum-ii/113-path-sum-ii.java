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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> sans = new ArrayList<>();
        pathSumHelper(root,targetSum,sans);
        return ans;
    }
    public void pathSumHelper(TreeNode root,int tar,List<Integer> sans) {
        if(root == null) return;
        
         sans.add(root.val);
       
        if(root.left == null && root.right == null && root.val == tar) {
            ans.add(new ArrayList<>(sans));
            sans.remove(sans.size()-1);
            return;
        }
         else {
              pathSumHelper(root.left,tar-root.val,sans);
              pathSumHelper(root.right,tar-root.val,sans);
         } 
          sans.remove(sans.size()-1);
    }
}