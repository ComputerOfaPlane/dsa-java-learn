/*
we need to find the lenght of the loop in java, 

hashing:
we can associate each node we traverse with a time, as we traverse increase the time and store the (node, time) in a map
if the node occurs again answer is time - map.get

fast and slow pointer:
1. detect a loop
2. if detected, make one of the pointer constant and make the other one traverse while it reaches the same position again
*/
/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // code here.
        /*Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int number = 0;
        while(temp!=null){
            if(map.containsKey(temp)){
                return number-map.get(temp);
            }
            else{
                map.put(temp,number++);
            }
            temp = temp.next;
        }
        return 0;*/
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                int counter = 1;
                fast = fast.next;
                while(slow!=fast){
                    counter++;
                    fast = fast.next;
                }
                return counter;
            }
        }
        return 0;
    }
}