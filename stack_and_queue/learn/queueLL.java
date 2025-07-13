/*The structure of the node of the queue is
class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}*/

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
    void push(int a)
    {
        // Your code here
        QueueNode node = new QueueNode(a);
        if(rear==null){
            front = node; rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }
    
    //Function to pop front element from the queue.
    int pop()
    {
        // Your code here
        if(front==null) return -1;
        QueueNode temp = front;
        if(front==rear){
            front=null;
            rear=null;
            return temp.data;
        }
        front = front.next;
        temp.next = null;
        return temp.data;
    }
}




