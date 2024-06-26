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
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return balanceBSTHelper(0,list.size()-1,list);
    }
    public void inOrder(TreeNode root) {
        if(root == null) return;
        
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public TreeNode balanceBSTHelper(int left, int right, List<Integer> list) {
        if(left > right) return null;
        int mid = left + (right-left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balanceBSTHelper(left, mid-1, list);
        root.right = balanceBSTHelper(mid+1, right, list);
        return root;
    }
    
}