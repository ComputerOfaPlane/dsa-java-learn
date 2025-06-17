/*
given a list, which may or may not contain a loop

what we have to do is, if it contains a loop, return the starting point from where it loops

approach hashing? hash the nodes, the first node that reappears, is the node that is the starting point of the loop

optimal: slow and fast moving pointers

1. first detect the loop
2. if loop is detected,
        make slow as the head element
        now move slow and fast by 1 place until they meet,
        if they meet that is the required node
3. else return null

why moving slow to the head works?

lets say, the distance between the head node and the needed node is L1,
by the time slow pointer moves L1 distance, fast pointer will move 2L1 distance
thus making the distance between slow and fast pointer as L1
now as both of them in the loop now, the distance between slow and fast pointer is 'd' which will keep decreasing by 1
by the time slow pointer moves 'd' distance, the fast pointer will move '2d' distance, thus the distance between this intersection will be L1

thus we set slow to head again
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
    public ListNode detectCycle(ListNode head) {
        /*Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp!=null){
            if(set.contains(temp)) return temp;
            set.add(temp);
            temp = temp.next;
        }
        return null;*/
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}