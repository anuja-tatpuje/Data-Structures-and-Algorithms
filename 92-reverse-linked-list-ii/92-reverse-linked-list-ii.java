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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
    
        //pre == 1
        for(int i = 0; i<left-1; i++) pre = pre.next;
    
        //start = 2 
        ListNode start = pre.next;
        //then = 3
        ListNode then = start.next;
        //then.next = 4
        for(int i=0;i<right-left;i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}