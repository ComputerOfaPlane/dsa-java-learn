class LFUCache {

    final int max;                          // max capacity it can hold
    int curr;                               // curr size of cache
    int minf;                               // curr minimum freq
    Map<Integer, Node> map;                 // key,  node
    Map<Integer, DoublyLinkedList> freq;    // freq, dll

    public LFUCache(int capacity) {
        this.max = capacity;
        this.curr = 0;
        this.minf = 0;
        map = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public int get(int key) {
        Node get = map.get(key);
        if(get==null) return -1;
        update(get);
        return get.value;
    }
    
    public void put(int key, int value) {
        if(max==0) return;
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
        }
        else{
            curr+=1;
            if(curr>max){
                DoublyLinkedList list = freq.get(minf);
                map.remove(list.tail.prev.key);
                list.deleteNode(list.tail.prev);
                curr-=1;
            }
            minf = 1;
            Node node = new Node(key, value);
            DoublyLinkedList list = freq.getOrDefault(1,new DoublyLinkedList());
            list.addNode(node);
            freq.put(1,list);
            map.put(key,node);
        }
    }

    public void update(Node node){

    }
}

class Node{
    int key,value,count;
    Node next,prev;
    Node(int k, int v){
        this.key = k;
        this.value = v;
        this.count = 1;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList{
    Node head, tail;
    int size;
    DoublyLinkedList(){
        this.size = 0;
        this.head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.tail = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    public void addNode(Node node){
        Node nextnode = head.next;
        node.next = nextnode;
        node.prev = head;
        head.next = node;
        nextnode.prev = node;
        size += 1;
    }
    public void deleteNode(Node node){
        Node previous = node.prev;
        Node nextnode = node.next;
        previous.next = nextnode;
        nextnode.prev = previous;
        size -= 1;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */