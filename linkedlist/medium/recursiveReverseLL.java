/*
recursively reverse a singly linkedlist

in recursion we try to conquer subproblem then add up all the sub problems to get our answers

firstly solve for single node list

then solve for double node list

then and so on

if list have single node, we just return the node // base case

Now, we need to calculate our newhead, which will be just the recursive call till the last

now we make two variables,

front will be next of current node

now assume head and front to be a 2 node linkedlist and make them reverse

return the newhead;


*/
// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    Node reverseList(Node head) {
        if(head==null||head.next==null) return head;
        Node newhead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newhead;
    }
}