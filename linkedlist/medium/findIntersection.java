/*
given two heads of a linkedlist

you need to find a node which is intersecting between the two list
if no such list is intersecting return null;

approach 1: hashing
store the nodes of 1 list, and then traverse the other list while constantly checking if this node had occured previously or not

approach 2: sc O(1)
find the length of list 1
find the length of list 2
find the differnce 'd' and move the larger list pointer by d places
then move them together, if they are intersecting we could check

approach 3: Optimal TC=O(n1+n2), SC=O(1)
move both the pointers in the list at the same time
if one of them reaches null, move the pointer to the head of the other list
if they coincide return node else return null

proof:

let the size diff between both list be d
when the smaller list pointer reaches end
the larger list pointer is still d places behind
when we move them to other list they overlap superficially at how many places far they are from convergence
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        while(true){
            if(temp1==temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1==null && temp2==null) return null;
            if(temp1==null) temp1 = headB;
            if(temp2==null) temp2 = headA;
        }
    }
}