/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        
        que.addFirst(root);
        
        while(que.size() > 0) {
            int size = que.size();
            List<Integer> ans = new ArrayList<>();;
            while(size-->0) {
               Node top = que.removeFirst();
                ans.add(top.val);
                
                if(top.children != null) {
                    for(Node child : top.children) {
                        que.addLast(child);
                    }
                }
            }
            
            res.add(ans);
        }
        
        return res;
    }
}