import java.util.Scanner;

public class Queue {
    int size;
    Vertice queue[];
    int rear;
    int front;

    public Queue(int size)
    {
        this.size = size;
        queue = new Vertice[size];
        int rear = 0;
        int front = 0;
    }

    public void enqueue(Vertice i) {
        if (rear+1 != size)
        {
            queue[rear++]=i;
        }
        else {
            System.out.println("Queue Overflow!");
        }
    }

    public Vertice dequeue()
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
