/*
given a number represented as a linkedlist

eg: number = 123
    list   = 1->2->3->x

add 1 to the number

eg: 9->9->9->x
it should become 
1->0->0->0->x

*/
/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        int carry = add(head);
        if(carry>0){
            Node node = new Node(carry);
            node.next = head;
            return node;
        }
        return head;
    }
    static int add(Node head){
        if(head==null) return 1;
        else{
            int carry = add(head.next);
            head.data = (head.data + carry);
            if(head.data<10) return 0;
            head.data = 0;
            return 1;
        }
    }
}