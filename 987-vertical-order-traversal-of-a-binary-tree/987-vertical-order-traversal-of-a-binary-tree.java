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
    class pair implements Comparable<pair> {
        TreeNode root;
        int level;
        int vertLevel;
        public pair(TreeNode node,int level,int vertLevel) {
            this.root = node;
            this.level = level;
            this.vertLevel = vertLevel;
        }
        public int compareTo(pair other) {
          if(this.vertLevel == other.vertLevel) {
                    return this.root.val - other.root.val;
           } else {
                    return this.vertLevel - other.vertLevel;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        TreeMap<Integer, PriorityQueue<pair>> map = new TreeMap<>();
        
         LinkedList<pair> que = new LinkedList<>();
         que.addLast(new pair(root,0,0));
         
        while(que.size()>0) {
            int size = que.size();
            
            while(size-->0) {
                pair top = que.removeFirst();
                int level = top.level;
                int vertLevel = top.vertLevel;
                TreeNode node = top.root;
                
                 if(map.containsKey(level))
                {
                    map.get(level).add(top);
                 } else {
                     PriorityQueue<pair> prq = new PriorityQueue<>();
                     prq.add(top);
                     map.put(level,prq);
                 }
                     
                if(node.left != null) {
                    que.addLast(new pair(node.left,level-1,vertLevel+1));
                }
                if(node.right != null) {
                    que.addLast(new pair(node.right,level+1,vertLevel+1));
                }                
            }
        }
        Set<Map.Entry<Integer,PriorityQueue<pair>>> entries = map.entrySet();     
        for (Map.Entry<Integer,PriorityQueue<pair>> entry : entries) {
            PriorityQueue<pair> pq = entry.getValue();
            List<Integer> list = new ArrayList<>();
            
            while(pq.size()>0) {
                pair p = pq.remove();
                list.add(p.root.val);
            }
            
            res.add(list);
        }
        return res;
    }
}