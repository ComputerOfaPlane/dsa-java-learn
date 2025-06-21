/*
given a linkedlist with two pointers:
    1. then next pointer pointing to the next node
    2. the random pointer pointing to a random node

you need to clone this linkedlist and return the head of the clone linkedlist

*/
/*
approach 2:
1. insert cloned nodes between each node
2. attach the random pointers
3. then separate the lists
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        // insert new nodes between each node
        while(temp!=null){
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = temp.next.next;
        }
        // join the randomm pointers
        temp = head;
        while(temp!=null){
            Node random = temp.random;
            if(temp.random!=null) temp.next.random = random.next;
            temp = temp.next.next;
        }
        // join the next pointers and separate the copy nodes
        Node dummy = new Node(-1), dt = dummy;
        temp = head;
        while(temp!=null){
            Node nextoriginal = temp.next.next;
            Node copy = temp.next;
            dt.next = copy;
            dt = copy;
            temp.next = nextoriginal;
            temp = temp.next;
        }
        return dummy.next;
    }
}
/*
approach 1:

make a map<Node, Node>
key is the original node, value is the cloned node, then attach the links
*/
class approach1 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node copy = new Node(temp.val);
            map.put(temp,copy);
            temp = temp.next;
        }
        temp = head;
        map.put(null,null);
        while(temp!=null){
            Node nextnode = temp.next;
            Node randomnode = temp.random;
            map.get(temp).next = map.get(nextnode);
            map.get(temp).random = map.get(randomnode);
            temp = temp.next;
        }
        return map.get(head);
    }
}