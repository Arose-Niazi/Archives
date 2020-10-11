import java.util.Scanner;

public class PreFixTesting {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        String valid = new String();
        do{
            System.out.println("Enter Infix: ");
            valid = input.nextLine();
        }
        while(!InfixToPrefix.isValidInfix(valid));
        InfixToPrefix pretfix = new InfixToPrefix(valid);

        System.out.println(pretfix.getPrefix());
    }
}
