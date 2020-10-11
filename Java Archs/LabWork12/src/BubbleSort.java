import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    int sortedArray[];
    int size;

    public BubbleSort(int size,int bounds)
    {
        sortedArray = new int[size];
        Random random = new Random(0);
        for(int i=0; i<size; i++)
            sortedArray[i] = random.nextInt(bounds);
    }

    public void sortArray() {
        boolean swaped = true;
        for (int i = 1; (i < sortedArray.length && swaped); i++) {
            swaped=false;
            for (int k = 0; k < sortedArray.length - i; k++)
                if (sortedArray[k] > sortedArray[k + 1]) {
                    int h=sortedArray[k];
                    sortedArray[k]=sortedArray[k+1];
                    sortedArray[k+1]=h;
                    swaped=true;
                }
        }
    }

    @Override
    public String toString() {
        return "BubbleSort{" +
                "sortedArray=" + Arrays.toString(sortedArray) +
                ", size=" + size +
                '}';
    }

    public static void main(String args[])
    {
        BubbleSort bubbleSort = new BubbleSort(50000,500000);
        bubbleSort.sortArray();
        System.out.println(bubbleSort);
    }
}
