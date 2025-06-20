/*
given a linkedlist sort the linkedlist and return the new head;

you need to recursively break the list into two lists from the mid point onwards,

use dummy pointer to merge two lists

in the calculation of mid make sure of an edge case that, the mid is one before

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
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }
    static ListNode mid(ListNode head){
        ListNode slow = head, fast = head.next; // notice fast = head.next; very important we start fast from here
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode mergesort(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode mid = mid(head);
        ListNode nextofmid = mid.next;
        mid.next = null;
        ListNode left = mergesort(head);
        ListNode right = mergesort(nextofmid);
        return merge(left,right);
    }
    static ListNode merge(ListNode left, ListNode right){
        ListNode temp1 = left, temp2 = right, dummy = new ListNode(Integer.MIN_VALUE), dt = dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                dt.next = temp1;
                dt = temp1;
                temp1 = temp1.next;
            }
            else{
                dt.next = temp2;
                dt = temp2;
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            dt.next = temp1;
            dt = temp1;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            dt.next = temp2;
            dt = temp2;
            temp2 = temp2.next;
        }
        return dummy.next;
    }
}