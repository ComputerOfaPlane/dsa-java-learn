/*
delete the middle of a linkedlist

1. find length, then traverse to middle - 1 and then delete

2. slow and fast pointer:

use slow and fast pointer to find the middle,
we can use an extra pointer that points to the previous element

or we can give the fast pointer an head start
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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode slow = head, fast = head, prev = null;
        // instead of prev = null, we could have given fast = fast.next.next and then go on,
        // eventually when fast will be at the end, slow will be the element from where we could easily delete
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}