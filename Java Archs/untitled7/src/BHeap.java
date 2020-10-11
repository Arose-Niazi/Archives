import java.util.Random;
import java.util.Scanner;

// Java implementation of Min Heap
public class BHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public BHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        for(int i=0; i<Heap.length; i++) Heap[i] = Integer.MAX_VALUE;
    }


    private int parent(int pos)
    {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }


    private boolean hasLeftChild(int pos)
    {
        try {
            int x = Heap[leftChild(pos)];
            if(Heap[leftChild(pos)] == Integer.MAX_VALUE) return false;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return  true;
    }

    private boolean hasRightChild(int pos)
    {
        try {
            int x = Heap[rightChild(pos)];
            if(Heap[rightChild(pos)] == Integer.MAX_VALUE) return false;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return  true;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }


    // Function to insert a node into the heap
    public void insert(int element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        System.out.println("Inserted at:" + size + "   Value: " + element);
        if(size == 1) return;
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= (maxsize+1) / 2; i++) {
            try {
                boolean leaf = false;

                if(!hasLeftChild(i) && !hasRightChild(i))  leaf=true;
                System.out.println(((leaf) ? "LEAF: ":" PARENT: ") +  Heap[i]);
                if(hasLeftChild(i))
                    System.out.println("\tLEFT CHILD : " + Heap[leftChild(i)]);
                if(hasRightChild(i))
                    System.out.println("\tRIGHT CHILD :" + Heap[rightChild(i)]);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Aukat sa bahir");
            }
        }
    }

    // Driver code
    public static void main(String[] arg)
    {
        BHeap minHeap = new BHeap(12);

        Random r = new Random();
        Scanner input = new Scanner(System.in);

        for(int i=0; i<11; i++)
        {
            /*int x = r.nextInt(5000);
            minHeap.insert(x);*
            System.out.println("Inserted " + x);*/
            System.out.println("Enter number to insert at " + (i+1) + ": ");
            minHeap.insert(input.nextInt());

        }
        minHeap.print();
    }
} 