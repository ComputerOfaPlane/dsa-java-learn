/*
you are given two linkedlist
each linkedlist represents a number in reverse form

so if list = 1->2->3->x
number = 321

return sum of these list in the same format
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), dt = dummy, temp1 = l1, temp2 = l2;
        int carry = 0;
        while(temp1!=null || temp2!=null || carry>0){
            int a = temp1!=null?temp1.val:0;
            int b = temp2!=null?temp2.val:0;
            int sum = a + b + carry;
            ListNode node = new ListNode(sum%10);
            dt.next = node;
            dt = node;
            carry = sum/10;
            if(temp1!=null) temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
        }
        return dummy.next;
    }
}