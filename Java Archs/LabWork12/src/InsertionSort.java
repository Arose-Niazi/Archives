import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    int sortedArray[];
    int size;

    public InsertionSort(int size,int bounds)
    {
        sortedArray = new int[size];
        Random random = new Random(0);
        for(int i=0; i<size; i++)
            sortedArray[i] = random.nextInt(bounds);
    }

    public void sortArray()
    {
        int key, j;
        for(int i = 1; i<sortedArray.length; i++)
        {
            key = sortedArray[i];
            j=i-1;
            while(j >= 0 && sortedArray[j] > key)
            {
                sortedArray[j+1] = sortedArray[j--];
            }
            sortedArray[j+1]=key;
        }
    }

    @Override
    public String toString() {
        return "InsertionSort{" +
                "sortedArray=" + Arrays.toString(sortedArray) +
                ", size=" + size +
                '}';
    }

    public static void main(String args[])
    {
        InsertionSort insertionSort = new InsertionSort(50000,500000);
        insertionSort.sortArray();
        System.out.println(insertionSort);
    }
}
