/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

you can use some space and solve it, but for O(1) space

what we do here is

1. isolate the group, remember the previous node, the group head and the next node
2. reverse the group
3. prev.next = head of group after reverse
4. previous grouphead.next = nextnode

tc = O(n+n) sc = O(1)
repeat this
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode newhead = null;
        outer: while(temp!=null){
            ListNode store = temp;
            ListNode another = temp;
            for(int i=1; i<k; ++i){
                if(store.next==null) break outer;
                store = store.next;
            }
            ListNode nextnode = store.next;
            store.next = null;
            ListNode rev = rev(temp);
            if(newhead==null) newhead = rev;
            if(prev!=null) prev.next = rev;
            another.next = nextnode;
            prev = another;
            temp = nextnode;
        }
        return newhead;
    }
    static ListNode rev(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode nextnode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextnode;
        }
        return prev;
    }
}