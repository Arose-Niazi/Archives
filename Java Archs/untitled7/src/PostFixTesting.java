import java.util.Scanner;

public class PostFixTesting {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        String valid = new String();
        do{
            System.out.println("Enter Infix: ");
            valid = input.nextLine();
        }
        while(!InfixToPostfix.isValidInfix(valid));
        InfixToPostfix postfix = new InfixToPostfix(valid);

        System.out.println(postfix.getPostfix());
    }
}
