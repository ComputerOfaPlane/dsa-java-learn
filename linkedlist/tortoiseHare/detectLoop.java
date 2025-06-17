/*
detect if there is a loop in the linked list or not

we can run till constraints, do hashing of nodes to check visited, etc,

optimal: use slow and fast pointers

slow pointers move by one, fast pointers move by 2

if they meet at any point, we are in a loop:
    this is because, in a loop lets say the distance between slow and fast pointer is d
    after each movement, the distance decreases by 1
    eventually it becomes zero

if the fast reaches null, no cycle exists
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}