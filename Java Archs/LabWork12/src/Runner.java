
public class Runner {

    public static void main(String args[])
    {
        long time = System.currentTimeMillis();
        BubbleSort.main(args);
        System.out.println(System.currentTimeMillis()-time);
        time = System.currentTimeMillis();
        InsertionSort.main(args);
        System.out.println(System.currentTimeMillis()-time);
    }


}
