import java.util.Scanner;

public class Task1 {

    private static int tempNegCounter = 0;
    private static int tempPosCounter = 0;

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        Stack stack = new Stack();
        int tempNegative[] = new int[20];
        int tempPositive[] = new int[20];


        for(int i=0; i<6; i++)
        {
            System.out.print("Enter number to push in stack: ");
            stack.push(input.nextInt());
        }


        System.out.println("Elements Pushed in Stack: ");

        for(int i=0; i<6; i++)
        {
            int x = stack.pop();
            if(isNegative(x)) tempNegative[tempNegCounter++] = x;
            if(isPositive(x)) tempPositive[tempPosCounter++] = x;
            System.out.print( x + "\t");
        }
        System.out.println("");

        display(tempNegative,tempPositive);

    }

    private static boolean isNegative(int x)
    {
        if (x > 0) return false;
        else return true;
    }

    private static boolean isPositive(int x)
    {
        if (x >= 0) return true;
        else return false;
    }

    private static void display(int tempNegative[], int tempPositive[])
    {
        System.out.print("Positive elements in in Stack: ");
        for(int i=0; i<tempPosCounter; i++)
        {
            System.out.print( tempPositive[i] + "\t");
        }
        System.out.println("");
        System.out.print("Negative elements in in Stack: ");
        for(int i=0; i<tempNegCounter; i++)
        {
            System.out.print( tempNegative[i] + "\t");
        }
        System.out.println("");
    }

}
