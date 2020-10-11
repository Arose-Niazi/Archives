/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arose
 */
import java.util.Scanner;
public class Driver4 {
  public static void main (String args[]){
   Scanner input=new Scanner(System.in);
   Marks m[]=new Marks[2];
   System.out.print("Enter your roll number: ");
   String rollno = input.nextLine();
   System.out.print("enter student name:");
   String n=input.nextLine();
   System.out.print("enter your department:");
   String d=input.nextLine();
   System.out.print("enter your programme:");
   String p=input.nextLine();
   for(int i=0; i<5; i++)
   {
   System.out.print("enter your subject name:");
   String x=input.nextLine();
   System.out.print("enter your 18subject marks:");
   double M=input.nextDouble();
   input.nextLine();
   m[i]= new Marks(x,M);
   }
   System.out.println(m);
   Student2 s=new Student2(rollno,n,d,p,m);
   System.out.println(s);
   
   
    
   }    
      
      
  }
