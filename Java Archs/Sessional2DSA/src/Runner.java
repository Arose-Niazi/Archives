/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A J
 */
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Runner 
{
    public static void main(String[] args) 
    {
        LinkedListClass list = new LinkedListClass();
        Scanner user_input = new Scanner(System.in);
        Random random_number = new Random();

        try 
		{	
			System.out.print("Enter size of link list");
			int size = user_input.nextInt();
			
			for(int i= 0 ; i<size;i++)
			{
				int randomnumber= random_number.nextInt(100);
				list.Create(randomnumber);
			}
			
			list.display_linkedlist();
			
			System.out.println("\nInserting a number --->");
			
			System.out.print("Enter the digit:");
			int number = user_input.nextInt();
			
			System.out.print("Enter the index:");
			int index = user_input.nextInt();
			
			
			list.insert(index, number);
			list.display_linkedlist();
			
			System.out.println("\nSearching a number --->");
			
			System.out.print("Enter the digit to search: ");
			int search = user_input.nextInt();
			
			int searchindex = list.search(search);
			if(searchindex != -1)
			{
				System.out.println("The digit is at index " + searchindex);
			}
			
			System.out.println("\nRemoving a number --->");
			
			System.out.print("Enter the index to remove: ");
			int remove = user_input.nextInt();
			
			list.remove(remove);
			list.display_linkedlist();
		}
		catch(InputMismatchException e)
		{
			System.out.println("You entered a non integer value. PROGRAM ENDS!");
		} 
        list.printMiddle();
        list.deleteMiddle();
        list.display_linkedlist();
        list.sortList();
        System.out.println("Sorting of Linked List");
        list.display_linkedlist();
        list.removeDuplicates();
        System.out.println("After remving dulicate of Linked List");
        list.display_linkedlist();

        System.out.println("Smallest element: " + list.smallestElement(list.head));
        
        
       
    }
    
    
}
