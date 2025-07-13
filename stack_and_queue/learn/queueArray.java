class Queue{

    int front;
    int rear;
    int size;
    int queue[];

    Queue(int n){
        this.size = n;
        queue = new int[n];
        front = -1;
        rear = -1;
    }

    static void add(int x){
        if((front==0 && rear==size-1) || (rear+1==front)) return;
        rear = (rear+1)%size;
        queue[rear] = x;
        return;
    }

    static int poll(){
        if(front==-1) return Integer.MIN_VALUE;
        int t = queue[front];
        if(front==rear){
            front = -1;
            rear = -1;
        }
        else{
            front = (front+1)%size;
        }
        return t;
    }
}