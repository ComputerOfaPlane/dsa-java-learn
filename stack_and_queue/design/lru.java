/*
we maitain a hashmap to quickly get the values

map stores <key, Node>

we maintain a doubly linkedlist for quick O(1) deletions and additions of node
*/

class LRUCache {

    Map<Integer,Node> map;
    Node dummy;
    Node end;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.dummy = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.end = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        dummy.next = end;
        end.prev= dummy;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int ans = map.get(key).value;
        move(map.get(key));
        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            move(map.get(key));
        }
        else{
            if(size==map.size()){
                // deleted the last
                Node beforend = end.prev;
                map.remove(beforend.key);
                end.prev = end.prev.prev;
                beforend.prev.next = end;
                beforend.next = null;
                beforend.prev = null;
            }
            // add to the first
            Node nextnode = dummy.next;
            Node newnode = new Node(key,value);
            newnode.next = nextnode;
            nextnode.prev = newnode;
            dummy.next = newnode;
            newnode.prev = dummy;
            map.put(key,newnode);
        }
    }

    private void move(Node node){
        Node previous = node.prev;
        Node nextnode = node.next;
        previous.next = nextnode;
        nextnode.prev = previous;
        Node first = dummy.next;
        dummy.next = node;
        node.prev = dummy;
        node.next = first;
        first.prev = node;
    }
}
class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int k, int v){
        this.key = k;
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */