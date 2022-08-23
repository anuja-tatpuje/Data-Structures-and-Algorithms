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
    int len;
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverseLL(slow);
        fast = head;
        
        while(slow != null) {
            if(slow.val != fast.val) return false;
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            len+= 1;
        }
        
        return prev;
    }
}