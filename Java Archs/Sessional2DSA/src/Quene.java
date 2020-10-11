import java.util.Scanner;

public class Quene {
    int size = 10;
    int quene[] = new int[size];
    int rear = 0;
    int front = 0;

    public static void main(String args[])
    {
        Quene q = new Quene();
        Scanner input = new Scanner(System.in);

        for(int i=0; i<5; i++)
        {
            System.out.print("Enter number to put in queue: ");
            q.enquene(input.nextInt());
        }


        System.out.println("Dequeue: " + q.dequene());
        System.out.println("Enqueue: " + 75);
        q.enquene(75);
        System.out.println("Enqueue: " + 65);
        q.enquene(65);

        System.out.println("Dequeue: " + q.dequene());
        System.out.println("Dequeue: " + q.dequene());
        System.out.println("Dequeue: " + q.dequene());

    }
    public void enquene(int i) {
        if (rear+1 != size)
        {
            quene[rear++]=i;
        }
        else {
            System.out.println("Queue Overflow!");
        }
    }

    public int dequene()
    {
        if(front+1 != size)
        {
            return quene[front++];
        }
        System.out.println("Queue underflow!");
        return 0;
    }

    public String toString()
    {
        return quene.toString();
    }


}
