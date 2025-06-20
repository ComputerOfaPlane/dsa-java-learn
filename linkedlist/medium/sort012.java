/*
given a linkedlist with data in the nodes being 0, 1 & 2.
Sort this list

approach: you may count the 0s, 1s & 2s; then overwrite the data in the nodes with them

one pass:

create three dummy nodes, link 0s, 1s & 2s in their respective nodes

then join the end of zero nodes to one nodes, then one nodes to two nodes

mark the end of two nodes as null

space complexity = O(1)
*/
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution
{
    public static Node sortList(Node head) {
        // Write your code here
        if(head==null || head.next == null) return head;
        Node temp = head;
        Node zerohead = new Node(-1);
        Node onehead = new Node(-1);
        Node twohead = new Node(-1);
        Node zero = zerohead, one = onehead, two = twohead;
        while(temp!=null){
            switch(temp.data){
                case 0:
                zero.next = temp;
                zero = temp;
                break;
                case 1:
                one.next = temp;
                one = temp;
                break;
                default:
                two.next = temp;
                two = temp;
                break;
            }
            temp = temp.next;
        }
        zero.next = onehead.next==null?null:onehead.next;
        one.next = twohead.next==null?null:twohead.next;
        two.next = null;
        return zerohead.next;
    }
}