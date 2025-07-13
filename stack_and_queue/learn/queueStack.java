/*
make a queue using stack

we will be using two stacks

i can not comprehend the better way and i also need to move on, i will revisit this later
*/
class MyQueue {

    Stack<Integer> stack1;

    public MyQueue() {
        stack1 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        Stack<Integer> stack2 = new Stack<>();
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        int t = stack2.pop();
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        return t;
    }
    
    public int peek() {
        Stack<Integer> stack2 = new Stack<>();
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        int t = stack2.peek();
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        return t;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */