/*
we need to find the middle of a linkedlist, we can do it by a number of ways,
like storing, two pass, finding lengths, etc

optimal:

Tortoise and Hare method:

in this method we take two pointers, one slow moving and one fast moving

for this problem
slow moving moves one element at a time
fast moving will move two element at a time

by the time fast moving pointer reaches the end of list, by jumping twice, slow moving pointer will be pointing at the middle node
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}