/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class pair implements Comparable<pair> {
        int li;
        ListNode node;
        
        pair(int li,ListNode node) {
            this.li = li;
            this.node = node;
        }
        
        public int compareTo(pair other) {
            return this.node.val - other.node.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode headResult = null;
        
         if(lists.length == 0) {
              return head;
         }

        int k = lists.length;
        PriorityQueue<pair> pq = new PriorityQueue<>(); 
        
        for(int i=0;i<k;i++) {
            if(lists[i] != null) 
            pq.add(new pair(i,lists[i]));
        }
        
        
        while(pq.size() > 0) {
            
            pair top = pq.remove();
            
            if(head == null) {
                head = top.node;
                headResult = head;
            } else {
                head.next = top.node;
                head = head.next;
            }
            
            int li = top.li;
            ListNode node = top.node;
            
            if(node.next != null) {
                pair p = new pair(li,node.next);
                pq.add(p);
            }
            
        }
        
        return headResult;
    }
}