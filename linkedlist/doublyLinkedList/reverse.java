/*
just how we swap two numbers using a temp variable, swap the links using another variable;
when swap is done we can move forward by doing curr = curr.back since before swap back was the next element
the last element to be performed by swap upon is the head of the list
*/
/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if(head==null || head.next==null) return head;
        DLLNode temp = head;
        DLLNode last = null;
        while(temp!=null){
            last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;
            temp = temp.prev;
        }
        return last.prev;
    }
}