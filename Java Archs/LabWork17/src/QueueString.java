
public class QueueString {
    int size;
    String queue[];
    int rear;
    int front;

    public QueueString(int size)
    {
        this.size = size;
        queue = new String[size];
        int rear = 0;
        int front = 0;
    }

    public void enqueue(String i) {
        if (rear+1 != size)
        {
            queue[rear++]=i;
        }
        else {
            System.out.println("Queue Overflow!");
        }
    }

    public String dequeue()
    {
        if(front+1 != size)
        {
            return queue[front++];
        }
        System.out.println("Queue underflow!");
        return null;
    }

    public String toString()
    {
        return queue.toString();
    }


}
