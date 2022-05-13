/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) 
            return root;
        Node rootNode = helper(root);
        return rootNode;
    }
    public Node helper(Node root) {
        Node rootNode = root;
        
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size()>0) {
            int size = que.size();
            for(int i=0;i<size;i++) {
                Node n = que.removeFirst();
                if(i==size-1) {
                    n.next = null;
                } else {
                    Node nextNode = que.peek();
                    n.next = nextNode;
                }
                if(n.left != null) {
                    que.addLast(n.left);
                } 
                if(n.right != null) {
                    que.addLast(n.right);
                }
            }
        }
        
        return rootNode;
    }
}