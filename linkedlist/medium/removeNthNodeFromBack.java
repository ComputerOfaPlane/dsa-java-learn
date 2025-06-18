/*
remove nth node from back

take two pointers

first move fast pointer n times

if fast==null remove head;

then move both fast and slow pointer together one at a time untill last node is reached by the fast pointer
remove the node at slow pointer
*/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode slow = head, fast = head;
        while(n-->0) fast = fast.next;
        if(fast==null) return head.next;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}