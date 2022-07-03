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
    int cameras;
    private int NOT_MONITORED = 0;
    private int MONITORED_NOCAM = 1;
    private int MONITORED_WITHCAM = 2;
    
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        int top = minCameraMonCover(root);
        return cameras + (top == NOT_MONITORED ? 1 : 0);
    }
    public int minCameraMonCover(TreeNode root) {
        if(root == null) return MONITORED_NOCAM;
        int lVal = minCameraMonCover(root.left);
        int rVal = minCameraMonCover(root.right);
        if(lVal == MONITORED_NOCAM && rVal == MONITORED_NOCAM) {
            return NOT_MONITORED;
        } else if(lVal == NOT_MONITORED || rVal == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITHCAM;
        } else {
            return MONITORED_NOCAM;
        }
    }
}