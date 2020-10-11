import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedList {

    LinkedList next;
    String data;

    public LinkedList(String data)
    {
        this.data=data;
        next=null;
    }

    public void addEnd(String data)
    {
        LinkedList nextPlace= this;
        while (nextPlace.next != null)
        {
            nextPlace=nextPlace.next;
        }

        LinkedList newList = new LinkedList(data);
        nextPlace.next = newList;

    }

    public void addStart(String data)
    {
        LinkedList newList = new LinkedList(this.data);
        newList.next=next;
        next = newList;
        this.data=data;
    }

    public void add(int loc, String data)
    {
        if(loc == 0) {
            addStart(data);
            return;
        }
        LinkedList toadd = next;
        LinkedList previous = this;

        boolean triggerEnd = false;
        for(int i=0; i<loc-1; i++)
        {
            if(triggerEnd){
                System.out.println("*** ERROR: Index not found!");
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

    public void remove(int loc)
    {
        if(loc == 0) {
            data = next.data;
            next = next.next;
            return;
        }
        LinkedList toadd = next;
        LinkedList previous = this;

        boolean triggerEnd = false;
        for(int i=0; i<loc-1; i++)
        {
            if(triggerEnd){
                System.out.println("*** ERROR: Index not found!");
                return;
            }
            if(toadd.next == null) triggerEnd = true;
            previous=toadd;
            toadd=toadd.next;

        }
        if(triggerEnd)
        {
            System.out.println("*** ERROR: Index not found!");
            return;
        }
        previous.next = toadd.next;
    }

    public int search(String num)
    {
        int index=0;
        LinkedList findingEmptyList = this;
        while(true){
            if(findingEmptyList.data.equals(num)) return index;
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
            index++;
        }
        return -1;
    }

    public int searchwith(String num, int time)
    {
        int index=0;
        LinkedList findingEmptyList = this;
        while(true){
            if(findingEmptyList.data.equals(num))
            {
                if(time != 0)
                {
                    time--;
                }
                else return index;
            }
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
            index++;
        }
        return -1;
    }

    public String get(int index)
    {
        LinkedList findingEmptyList = this;
        for(int i=0; i<index; i++)
        {
            findingEmptyList = findingEmptyList.next;
        }
        return findingEmptyList.data;
    }

    public int count(String num)
    {
        int timesrepeated=0;
        LinkedList findingEmptyList = this;
        while(true){
            if(findingEmptyList.data.equals(num)) timesrepeated++;
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
        }
        return timesrepeated;
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