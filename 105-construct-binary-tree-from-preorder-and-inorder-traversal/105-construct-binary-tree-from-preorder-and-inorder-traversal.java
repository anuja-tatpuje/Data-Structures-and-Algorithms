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
    public TreeNode build(int[] pre,int psi,int pei,int isi,int iei,int[] in) {
        if(psi>pei)
            return null;
        if(psi == pei) {
            return new TreeNode(pre[psi]);
        }
        
        TreeNode root = new TreeNode(pre[psi]);
        
        int j = isi;
        int count = 0;
        
        while(in[j] != root.val) {
            j++;
            count++;
        }
        
        root.left = build(pre,psi+1,psi+count,isi,j-1,in);
        root.right = build(pre,psi+count+1,pei,j+1,iei,in);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,0,inorder.length-1,inorder);
    }
}