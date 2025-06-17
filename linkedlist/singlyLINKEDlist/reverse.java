/*
given the head of a linkedlist, we need to reverse the linked list

one method of doing this is by using stack:
1. traverse the list and push all the elements in the stack
2. again traverse but now overwrite the data part with the top elements of stack and pop the stack

method 2:
in place, swap the links, it becomes a one pass solution
similar to how we swap two numbers, we can swap the links

store the current head, make a previous element as null

while temp is not null that is not the end of the list
    take a temporary variable that stores the next node
    overwrite the link of current node to next node to current node to previous node :) curr->next becomes curr->prev
    make the previous element now point to temp node
    make the current node as nextnode

return the previous node as the current node becomes null
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
    public ListNode reverseListOnePass(ListNode head) {
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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}