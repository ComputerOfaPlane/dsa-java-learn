/*
rotate a linkedlist by k places

1. join tail to the head
2. find the particular node that will be the new head
3. mark the prev.next as null
4. return the new head;
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode slow = head, fast = head, temp = head; int c = 0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        k = k%c;
        for(int i=1; i<=k; ++i) fast = fast.next;
        if(fast==null) return head;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        // System.out.println(slow.val);
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}