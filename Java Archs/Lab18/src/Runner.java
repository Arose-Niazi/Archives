import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String args[])
    {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        HashTable hashTable = new HashTable(2);
        for(int i=0; i<6; i++)
        {
            System.out.print("Enter username: ");
            String name  = input.nextLine();
            System.out.print("Enter pass: ");
            String pass  = input.nextLine();
            hashTable.insert(name,pass);
        }

        while(true)
        {
            System.out.print("Enter pass to check: ");
            String pass = input.nextLine();
            if(pass.isEmpty()) break;
            System.out.println("Usernames:");
            hashTable.getUsername(pass);
        }

    }
}
