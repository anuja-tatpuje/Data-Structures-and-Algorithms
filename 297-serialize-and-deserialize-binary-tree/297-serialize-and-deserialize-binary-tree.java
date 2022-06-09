/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        
        String left = serialize(root.left);
        String right = serialize(root.right);
        
        return ""+root.val+","+left+","+right;
    }
    
    int index;
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return helper(nodes);
    }
    public TreeNode helper(String[] nodes) {
        if(nodes[index].equals("null")) {
            index++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        
        root.left = helper(nodes);
        root.right = helper(nodes);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));