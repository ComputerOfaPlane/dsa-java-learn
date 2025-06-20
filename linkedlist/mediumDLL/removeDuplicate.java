/*
remove duplicate node data from sorted doubly linkedlist

just implement, i do not know what to explain here

*/
class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node temp = head;
        while(temp.next!=null){
            Node nex = temp.next;
            if(temp.data==nex.data){
                Node ahead = temp.next.next;
                if(ahead==null) temp.next = null; // tail
                else{
                    temp.next = ahead;
                    ahead.prev = temp;
                }
            }
            else temp = temp.next;
        }
        return head;
    }
}