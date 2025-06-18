/*
given a singly linkedlist check if the list is pallindrome or not:

first: we can do it using stack tc = O(n) sc = O(n)

if we want to avoid the space complexity,

we can:

1. find the middle element using fast and slow pointers n/2 floor div
2. then reverse the list from next node onwards
3. now compare the two sublists
4. rever the changes made to the list
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
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = rev(slow.next);
        ListNode first = head;
        while(second!=null){
            if(first.val!=second.val) return false;
            first = first.next;
            second = second.next;
        }
        rev(slow.next);
        return true;
    }
    public static ListNode rev(ListNode head){
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