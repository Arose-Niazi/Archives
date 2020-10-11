package Another;

import java.util.Scanner;

public class Tester {
    public static void main(String args[])
    {

        Scanner input = new Scanner(System.in);
        try
        {
            EquationChecker e = new EquationChecker(input.nextLine());
        }
        catch (Exception e)
        {
            System.out.println("Sorry Invalid Equation");
            main(args);
        }
    }
}
