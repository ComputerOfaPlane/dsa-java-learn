/*
given a singly linkedlist,
you need to segregate nodes at odd index and even indexes

we can use two queues to store the values and over write the values;

optimal:

manipulate the links such that in a list

1 2 3 4 5

1->3->5
2->4

now do 5->4

done!
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head, even = head.next, evenhead = even;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}