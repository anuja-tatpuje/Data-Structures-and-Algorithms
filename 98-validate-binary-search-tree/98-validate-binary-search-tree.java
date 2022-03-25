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
    public boolean isValidBST(TreeNode root) {   
         TreeNode curr = root;
         TreeNode prev = null;
         
        while(curr!= null) {
            TreeNode left = curr.left;
            
            if(left == null) {
               if(prev != null && prev.val >= curr.val)
                   return false;
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode rm = rightMost(left,curr);
                
                if(rm.right == null) { // Thread creation
                    rm.right = curr;
                    curr = left;
                } else { // thread break
                    rm.right = null;
                   if(prev != null && prev.val >= curr.val)
                   return false;
                    prev = curr;        
                    curr = curr.right;
                }
            }
        }
        
        return true;
    }
    
    public boolean validateBSTWithMorrisTraversalAndArrayList(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         
         TreeNode curr = root;
         
        while(curr!= null) {
            TreeNode left = curr.left;
            
            if(left == null) {
                if(ans.size()>0) {
                   int a = ans.get(ans.size()-1);
                   if(a > curr.val)
                       return false;
                }
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rm = rightMost(left,curr);
                
                if(rm.right == null) { // Thread creation
                    rm.right = curr;
                    curr = left;
                } else { // thread break
                    rm.right = null;
                    if(ans.size()>0) {
                      int a = ans.get(ans.size()-1);
                      if(a > curr.val)
                        return false;
                    }

                    ans.add(curr.val);
                    
                    curr = curr.right;
                }
            }
        }
        
        return true;
    }
    
    public TreeNode rightMost(TreeNode node,TreeNode curr) {
        while(node.right != null && node.right != curr) {
            node = node.right;
        }
        
        return node;
    }
}