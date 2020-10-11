/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 10/14/19
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedList {

    public static void main(String args[])
    {
        LinkedList ll = new LinkedList(5);
        ll.displayAll();
        ll.addStart(6);
        ll.addEnd(7);
        ll.displayAll();
        ll.add(0,8);
        ll.add(3,5);
        ll.add(25,500);
        ll.displayAll();
        ll.displayFirstLast();
        System.out.println("Number of 5's stored in: " + ll.count(5));
    }

    LinkedList next;
    int data;

    public LinkedList(int data)
    {
        this.data=data;
        next=null;
    }

    public void addEnd(int data)
    {
        LinkedList nextPlace=next;
        while (nextPlace.next != null)
        {
            nextPlace=nextPlace.next;
        }

        LinkedList newList = new LinkedList(data);
        nextPlace.next = newList;

    }

    public void addStart(int data)
    {
        LinkedList newList = new LinkedList(this.data);
        newList.next=next;
        next = newList;
        this.data=data;
    }

    public void add(int loc, int data)
    {
        if(loc == 0) {
            addStart(data);
            return;
        }
        LinkedList toadd = this;
        LinkedList previous = null;

        boolean triggerEnd = false;
        for(int i=0; i<loc-1; i++)
        {
            if(triggerEnd){
                System.out.println("Error this location does not exist");
                return;
            }
            if(toadd.next == null) triggerEnd = true;
            previous=toadd;
            toadd=toadd.next;

        }
        if(triggerEnd)
        {
            addEnd(data);
            return;
        }
        LinkedList newData = new LinkedList(data);
        previous.next = newData;
        newData.next=toadd;

    }

    public int count(int num)
    {
        int timesrepeated=0;
        LinkedList findingEmptyList = this;
        while(true){
            if(findingEmptyList.data == num) timesrepeated++;
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
        }
        return timesrepeated;
    }

    public void displayFirstLast()
    {
        System.out.println("First Data: " + data);
        LinkedList findingEmptyList = this;
        while(true){
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
        }
        System.out.println("First Data: " + findingEmptyList.data);
    }

    public void displayAll()
    {
        System.out.println("Printing Data:");
        LinkedList findingEmptyList = this;
        while(true){
            System.out.println("Data: " + findingEmptyList.data);
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
        }
    }
}
