import java.util.Random;
import java.util.Scanner;

class Scheduling {

    private StringQueue tasks;
    private StringQueue waitList;

    public Scheduling(int size)
    {
        tasks= new StringQueue(size+1);
        waitList = new StringQueue(size+1);
    }

    void addTask(String task)
    {
        if(!tasks.enqueue(task))
            waitList.enqueue(task);
        else
        {
            System.out.println("Added Task to list" + task);
            return;
        }
        System.out.println("Added task to waitlist: " + task);
    }

    void deleteTask()
    {
        String s = tasks.dequeue();
        if(s == null)
            System.out.println("No task to be deleted");
        else
        {
            System.out.println("Deleted: " + s);
            String q = waitList.dequeue();
            if(q != null)
                tasks.enqueue(q);
        }
    }

    boolean isEmpty()
    {
        if(tasks.peek() != null)
            return true;
        else
            return false;
    }

    void peek()
    {
        if(tasks.peek() != null)
            System.out.println("Peeked: " + tasks.peek());
        else
            System.out.println("No task to peek");
    }

    public static void main(String args[])
    {
        Scheduling c = new Scheduling(15);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Tasks to insert: ");
        int t = input.nextInt();
        for(int j=0; j<t; j++)
        {
            c.addTask("Task " + j);
        }
        System.out.print("Enter to tasks delete: ");
        t = input.nextInt();
        for(int i=0; i<t; i++)
        {
            c.deleteTask();
        }
        c.peek();

    }
}