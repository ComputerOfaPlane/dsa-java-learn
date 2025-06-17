class Node{
    int data;
    Node next;
    Node back;
    Node(int val, Node n, Node m){
        this.data = val;
        this.next = n;
        this.back = m;
    }
    Node(int val){
        this.data = val;
        this.next = null;
        this.back = null;
    }
}
class Main {
    public static void main(String[] args) {
        int arr[] = {99, 44, 91, 23, 40, 70, 14, 58, 68, 51, 5, 47, 93, 4, 22};
        Node head = convert(arr);
        print(head);
    }
//  ---------------- insert operations start ---------------- 
    static Node insertHead(Node head, int value){ // before head
        if(head==null) return new Node(value);
        Node temp = head;
        Node newnode = new Node(value);
        newnode.next = temp;
        temp.back = newnode;
        return newnode;
    }
    static Node insertTail(Node head, int value){ // before tail
        if(head.next==null) return insertHead(head,value);
        Node temp = head;
        while(temp.next!=null) temp = temp.next;
        Node previous = temp.back;
        Node newnode = new Node(value, temp, previous);
        previous.next = newnode;
        temp.back = newnode;
        return head;
    }
    static Node insertNode(Node head, int x, int value){ // before the position
        if(x==1) return insertHead(head, value);
        Node temp = head;
        int c = 0;
        while(temp!=null){
            c+=1;
            if(c==x) break;
            temp = temp.next;
        }
        Node previous = temp.back;
        Node newnode = new Node(value,temp,previous);
        previous.next = newnode;
        temp.back = newnode;
        return head;
    }
    static void insertNode(Node node, int value){
        Node ahead = node.next;
        Node previous = node.back;
        Node newnode = new Node(value, ahead, previous);
        previous.next = newnode;
        ahead.back = newnode;
    }
//  ---------------- insert operations end ---------------- 
//  ---------------- delete operations start ---------------- 
    static Node deleteHead(Node head){
        if(head==null || head.next==null) return null;
        Node temp = head;
        head = head.next;
        head.back = null;
        temp.next=null;
        return head;
    }
    static Node deleteTail(Node head){
        if(head==null || head.next==null) return null;
        Node temp = head;
        Node prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.back = null;
        return head;
    }
    static Node deleteNode(Node head, int x) {
        // code here
        if(head==null) return null;
        int i=0;
        Node temp = head;
        while(temp!=null){
            i+=1;
            if(i==x) break;
            temp = temp.next;
        }
        Node previous = temp.back;
        Node ahead = temp.next;
        if(previous==null && ahead==null) return null;
        if(ahead==null) return deleteTail(head);
        else if(previous==null) return deleteHead(head);
        else{
            previous.next = ahead;
            ahead.back = previous;
            temp.back = null;
            temp.next = null;
            return head;
        }
        // return head;
    }
    static void deleteNode(Node node){ // node is not the head element
        Node previous = node.back;
        Node ahead = node.next;
        if(ahead==null){
            previous.next = null;
            ahead.back = null;
            return;
        }
        previous.next = ahead;
        ahead.back = previous;
        node.next = null;
        node.back = null;
        return;
    }
//  ---------------- delete operations end ----------------
    static Node convert(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node newnode = new Node(arr[i]);
            newnode.back = temp;
            temp.next = newnode;
            temp = temp.next;
        }
        return head;
    }
    static void print(Node head){
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            System.out.print(temp.data+"->");
            prev = temp;
            temp = temp.next;
        }
        System.out.println("null");
        while(prev!=null){
            System.out.print(prev.data+"<-");
            prev = prev.back;
        }
        System.out.println("null");
    }
}