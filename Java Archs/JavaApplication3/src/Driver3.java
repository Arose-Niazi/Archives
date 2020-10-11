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
public class Driver3 {
public static void main(String args[]){
Scanner input=new Scanner(System.in);
String s[]=new String[5];



for(int i=0;i<5;i++){
    System.out.printf("please enter string ");
    s[i]=input.nextLine();
  
}
  System.out.print("\nyour Strings are:\n"); 
for(String e: s)
{
  System.out.println(e);
       
}
}
}