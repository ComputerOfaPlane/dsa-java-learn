/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

*/
/*
better way to reduce 2*N space complexity
1. initialize the min as integer max value
2. with every push update the min
3. if the min changes, instead of pushing the value, push !! ** 2*val - prevmin = newval ** !!, push new val
4. if top and min greater than peek top is min
else top is the real top
*/
class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) stack.push(new Pair(val,val));
        else{
            int min = Math.min(stack.peek().getsecond(),val);
            stack.push(new Pair(val,min));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getfirst();
    }
    
    public int getMin() {
        return stack.peek().getsecond();
    }
    class Pair{
        private int first;
        private int second;
        Pair(int a, int b){
            this.first = a;
            this.second = b;
        }
        int getfirst(){
            return first;
        }
        int getsecond(){
            return second;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */