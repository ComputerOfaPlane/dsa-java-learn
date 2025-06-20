/*
delete all occurence of a key value in a doubly linkedlist

(simple, make sure to delete head and tail correctly)


*/
// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head.next==null && head.data==x) return null;
        while(head.data==x){ // deletes head
            Node nex = head.next;
            head = head.next;
            nex.prev = null;
        }
        Node temp = head;
        while(temp.next!=null){ // deletes keys in middle
            if(temp.data==x){
                Node back = temp.prev;
                Node ahead = temp.next;
                back.next = ahead;
                ahead.prev = back;
            }
            temp = temp.next;
        }
        if(temp.data==x){ // deletes keys in tail
            Node back = temp.prev;
            back.next=null;
        }
        return head;
    }
}