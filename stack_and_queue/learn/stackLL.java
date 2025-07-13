/*
    3 -> 4 -> 5 -> 6 -> x
    ^top

*/

class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode node = new StackNode(a);
        if(top==null){
            top = node;
            return;
        }
        node.next = top;
        top = node;
        
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if(top==null) return -1;
        StackNode node = top;
        top = top.next;
        node.next = null;
        return node.data;
    }
}