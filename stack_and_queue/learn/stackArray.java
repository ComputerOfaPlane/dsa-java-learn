class Stack{

    int top;
    int stack[];
    int size;

    Stack(int n){
        this.top = -1;
        this.size = n;
        this.stack = new int[size];
    }

    staic void push(int x){
        if(top==size-1) return;
        top+=1;
        stack[top] = x;
        return;
    }

    static int pop(){
        if(top==-1) return Integer.MIN_VALUE;
        int t = stack[top];
        top-=1;
        return t;
    }
}