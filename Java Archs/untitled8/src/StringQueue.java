public class StringQueue
{

    String Queue[] = new String[16];

    int n, front, rear;
    public StringQueue(int size)
    {
        n=size;
        front = 0;
        rear=0;
    }

    public boolean enqueue(String item)

    {
        if((rear+1) % n != front)

        {
            rear = (rear+1)%n;

            Queue[rear] = item;
        }
        else
        {
            return false;
        }
        return true;
    }

    public String dequeue()
    {
        String item;

        if(front!=rear)
        {
            front = (front+1)%n;

            item = Queue[front];

            return item;
        }
        else
        {
            return null;
        }
    }

    public String peek()
    {
        String item;

        if(front!=rear)
        {
            int temp = (front+1)%n;

            item = Queue[temp];

            return item;
        }
        else
        {
            return null;
        }
    }

}